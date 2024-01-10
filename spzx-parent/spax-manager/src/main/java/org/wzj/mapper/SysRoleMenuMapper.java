package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.dto.system.AssginMenuDto;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper {
    // 查询当前角色的菜单数据
    List<Long> findSysRoleMenuByRoleId(Long roleId);

    // 根据角色的id删除其所对应的菜单数据
    void deleteByRoleId(Long roleId);

    // 获取菜单的id
    void doAssign(AssginMenuDto assginMenuDto);

    // 将该id的菜单设置为半开
    void updateSysRoleMenuIsHalf(Long id);
}
