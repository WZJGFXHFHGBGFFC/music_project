package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleUserMapper {

    // 删除之前的所有的用户所对应的角色数据
    void deleteByUserId(Long userId);

    // 分配新的角色数据
    void doAssign(Long userId, Long roleId);

    // 查询当前登录用户的角色数据
    List<Long> findSysUserRoleByUserId(Long userId);
}
