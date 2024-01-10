package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.entity.system.SysMenu;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    // 1 查询所有菜单，返回list列表
    List<SysMenu> selectAll();

    // 菜单添加
    void insert(SysMenu sysMenu);

    // 菜单·修改
    void updateById(SysMenu sysMenu);

    // 先查询是否存在子菜单
    int countByParentId(Long id);

    // 删除菜单
    void deleteById(Long id);

    List<SysMenu> selectListByUserId(Long userId);

    // 查询是否存在父节点
    SysMenu selectById(Long parentId);
}
