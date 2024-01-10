package org.wzj.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wzj.service.SysRoleMenuService;
import org.wzj.spzx.model.dto.system.AssginMenuDto;
import org.wzj.spzx.model.vo.common.Result;
import org.wzj.spzx.model.vo.common.ResultCodeEnum;

import java.util.Map;

@Tag(name = "分配菜单")
@RestController
@RequestMapping(value = "/admin/system/sysRoleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService ;

    //1 查询所有菜单和查询角色分配过菜单id列表
    @Operation(summary = "查询所有菜单和查询角色分配过菜单id列表")
    @GetMapping(value = "/findSysRoleMenuByRoleId/{roleId}")
    public Result<Map<String , Object>> findSysRoleMenuByRoleId(@PathVariable(value = "roleId") Long roleId) {
        Map<String , Object> sysRoleMenuList = sysRoleMenuService.findSysRoleMenuByRoleId(roleId) ;
        return Result.build(sysRoleMenuList , ResultCodeEnum.SUCCESS) ;
    }

    //2 保存角色分配菜单数据
    @Operation(summary = "保存角色分配菜单数据")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginMenuDto assginMenuDto) {
        System.out.println("========================");
        System.out.println(assginMenuDto.getMenuIdList());
        sysRoleMenuService.doAssign(assginMenuDto);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
