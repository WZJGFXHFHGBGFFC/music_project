package org.wzj.service;

import org.wzj.spzx.model.dto.system.AssginMenuDto;

import java.util.Map;

public interface SysRoleMenuService {
    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);

    //2 保存角色分配菜单数据
    void doAssign(AssginMenuDto assginMenuDto);
}
