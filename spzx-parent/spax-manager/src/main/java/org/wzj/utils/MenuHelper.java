package org.wzj.utils;

import net.bytebuddy.asm.Advice;
import org.wzj.spzx.model.entity.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

//封装树形菜单数据
public class MenuHelper {
    //递归实现封装过程
    public static List<SysMenu> buildTree(List<SysMenu> sysMenusList){
        ArrayList<SysMenu> trees = new ArrayList<>();
        for (SysMenu sysMenu : sysMenusList) {
            if (sysMenu.getParentId().longValue() == 0){
                trees.add(findChildren(sysMenu,sysMenusList));
            }
        }
        return trees;
    }
    // 递归查找下层菜单
    private static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> sysMenusList) {
        sysMenu.setChildren(new ArrayList<>());
        for (SysMenu menu : sysMenusList) {
            if(sysMenu.getId().longValue() == menu.getParentId()){
                sysMenu.getChildren().add(findChildren(menu,sysMenusList));
            }
        }
        return sysMenu;
    }

}
