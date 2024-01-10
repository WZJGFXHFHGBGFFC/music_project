package org.wzj.service;

import com.github.pagehelper.PageInfo;
import org.wzj.spzx.model.dto.system.AssginRoleDto;
import org.wzj.spzx.model.dto.system.LoginDto;
import org.wzj.spzx.model.dto.system.SysUserDto;
import org.wzj.spzx.model.entity.system.SysUser;
import org.wzj.spzx.model.vo.system.LoginVo;

public interface SysUserService {


    // 根据用户名查询用户数据
    public abstract LoginVo login(LoginDto loginDto) ;

    //获取当前用户登录信息
    SysUser getUserInfo(String token) ;

    void logout(String token);

    PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    //2.用户添加
    void saveSysUser(SysUser sysUser);

    //3.用户修改
    void updateSysUser(SysUser sysUser);

    //4.用户删除
    void deleteById(Long userId);

    //用户分配角色
    void doAssign(AssginRoleDto assginRoleDto);
}
