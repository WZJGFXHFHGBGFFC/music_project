package org.wzj.service;

import com.github.pagehelper.PageInfo;
import org.wzj.spzx.model.dto.system.SysRoleDto;
import org.wzj.spzx.model.entity.system.SysRole;

import java.util.Map;

public interface SysRoleService {
    //角色列表的方法
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit);

    //添加角色方法
    void saveSysRole(SysRole sysRole);

    //角色修改
    void updateSysRole(SysRole sysRole);

    void deleteById(Long roleId);

    //查询所有角色和该ID用户已分配角色
    Map<String, Object> findAllRoles(Long userId);
}
