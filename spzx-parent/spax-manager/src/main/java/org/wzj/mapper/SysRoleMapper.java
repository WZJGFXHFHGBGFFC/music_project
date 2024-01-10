package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.dto.system.SysRoleDto;
import org.wzj.spzx.model.entity.system.SysRole;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    //角色查询
    List<SysRole> findByPage(SysRoleDto sysRoleDto);

    //添加角色
    void save(SysRole sysRole);

    //角色修改
    void updateSysRole(SysRole sysRole);

    //角色逻辑删除
    void deleteById(Long roleId);

    //角色分配
    List<SysRole> findAllRoles();
}
