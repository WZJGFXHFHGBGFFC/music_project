package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.wzj.spzx.model.dto.system.SysRoleDto;
import org.wzj.spzx.model.dto.system.SysUserDto;
import org.wzj.spzx.model.entity.system.SysRole;
import org.wzj.spzx.model.entity.system.SysUser;

import java.util.List;

@Mapper
public interface SysUserMapper {


    //2.更具用户查询数据库表sys_user表
    SysUser selectUserInfoUserName(String userName);

    //1.用户条件分页查询接口
    List<SysUser> findByPage(SysUserDto sysUserDto);

    //2.1根据输入的用户名查询用户(用户添加)
    SysUser findByUserName(String userName);

    //2.2对密码进行加密(用户添加)
    void saveSysUser(SysUser sysUser);

    //3.用户更新
    void updateSysUser(SysUser sysUser);

    //4.用户删除
    void deleteById(Long userId);
}
