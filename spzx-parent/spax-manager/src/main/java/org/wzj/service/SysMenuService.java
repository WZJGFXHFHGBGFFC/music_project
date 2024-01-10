package org.wzj.service;

import org.wzj.spzx.model.entity.system.SysMenu;
import org.wzj.spzx.model.vo.system.SysMenuVo;

import java.util.List;

public interface SysMenuService {
    // 查询菜单列表
    List<SysMenu> findNodes();

    // 菜单添加
    void save(SysMenu sysMenu);

    //菜单修改
    void updateById(SysMenu sysMenu);

    // 菜单删除
    void removeById(Long id);

    List<SysMenuVo> findUserMenuList();
}
