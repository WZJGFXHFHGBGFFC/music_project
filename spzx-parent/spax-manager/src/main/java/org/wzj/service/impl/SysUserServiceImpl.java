package org.wzj.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.wzj.exception.WzjException;
import org.wzj.mapper.SysRoleUserMapper;
import org.wzj.mapper.SysUserMapper;
import org.wzj.service.SysUserService;
import org.wzj.spzx.model.dto.system.AssginRoleDto;
import org.wzj.spzx.model.dto.system.LoginDto;
import org.wzj.spzx.model.dto.system.SysUserDto;
import org.wzj.spzx.model.entity.system.SysUser;
import org.wzj.spzx.model.vo.common.ResultCodeEnum;
import org.wzj.spzx.model.vo.system.LoginVo;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper ;

    //根据用户名查询用户数据(登录)
    @Override
    public LoginVo login(LoginDto loginDto) {

        /*
        获取输入验证码和储存redis的key名称 loginDto
         */
        String captcha = loginDto.getCaptcha();
        String key = loginDto.getCodeKey();

        //根据获取的redis里面的key,查询redis里面储存的验证码
        String redisCode = redisTemplate.opsForValue().get("user:login:validatecode:" + key);

        // 比较输入的验证码和redis存储验证码是否一致
        if (StrUtil.isEmpty(redisCode) || !StrUtil.equalsAnyIgnoreCase(redisCode, captcha)) {
            throw new WzjException(ResultCodeEnum.VALIDATECODE_ERROR);
        }

        /*
        如果一致，删除redis里面验证码
         */
        redisTemplate.delete("user:login:validatecode:" + key);

        //1.获取提交用户名
        String userName = loginDto.getUserName();

        //2.更具用户查询数据库表sys_user表
        SysUser sysUser = sysUserMapper.selectUserInfoUserName(userName);

        //3.判定是否能查询到用户数据
        if (sysUser == null) {
            throw new WzjException(ResultCodeEnum.LOGIN_ERROR);
        }

        //4.如果用户数据存在，则获取输入的密码和数据库密码进行比对
        String userPassword = sysUser.getPassword();
        String loginDtoPassword = loginDto.getPassword();

        //5.把输入的密码进行加密后和数据库密码进行比对
        loginDtoPassword = DigestUtils.md5DigestAsHex(loginDtoPassword.getBytes());
        if (!loginDtoPassword.equals(userPassword)) {
            throw new WzjException(ResultCodeEnum.LOGIN_ERROR);
        }

        //6.密码正确，生成唯一的token
        String token = UUID.randomUUID().toString().replace("-", "");

        //7.把登录成功的用户信息放入redis
        redisTemplate.opsForValue().set("user:login" + token, JSON.toJSONString(sysUser), 7, TimeUnit.DAYS);

        //8.返回LoginVo
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);

        return loginVo;
    }

    //获取当前用户登录信息()
    @Override
    public SysUser getUserInfo(String token) {
        String userJson = redisTemplate.opsForValue().get("user:login" + token);
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);
        return sysUser;
    }

    //退出账号功能
    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login"+token);
    }


    //1.用户条件分页查询接口
    @Override
    public PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUserList = sysUserMapper.findByPage(sysUserDto);
        PageInfo pageInfo = new PageInfo(sysUserList);
        return pageInfo;
    }

    //2.用户添加
    @Override
    public void saveSysUser(SysUser sysUser) {
        // 根据输入的用户名查询用户
        SysUser dbSysUser = sysUserMapper.findByUserName(sysUser.getUserName()) ;
        if(dbSysUser != null) {
            throw new WzjException(ResultCodeEnum.USER_NAME_IS_EXISTS) ;
        }

        // 对密码进行加密
        String password = sysUser.getPassword();
        String digestPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        sysUser.setPassword(digestPassword);
        sysUser.setStatus(0);
        sysUserMapper.saveSysUser(sysUser) ;
    }

    //3.用户修改
    @Override
    public void updateSysUser(SysUser sysUser) {
        sysUserMapper.updateSysUser(sysUser) ;
    }

    //4.用户删除
    @Override
    public void deleteById(Long userId) {
        sysUserMapper.deleteById(userId);
    }

    //用户分配角色


    @Transactional
    @Override
    public void doAssign(AssginRoleDto assginRoleDto) {

        // 删除之前的所有的用户所对应的角色数据
        sysRoleUserMapper.deleteByUserId(assginRoleDto.getUserId()) ;

        // 分配新的角色数据
        List<Long> roleIdList = assginRoleDto.getRoleIdList();
        roleIdList.forEach(roleId->{
            sysRoleUserMapper.doAssign(assginRoleDto.getUserId(),roleId);
        });
    }
}