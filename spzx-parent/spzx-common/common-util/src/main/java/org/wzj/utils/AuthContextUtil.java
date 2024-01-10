package org.wzj.utils;

import org.wzj.spzx.model.entity.system.SysUser;

public class AuthContextUtil {
    //创建一个threadLocal
    private static final ThreadLocal<SysUser> threadLocal = new ThreadLocal<>();

    //添加数据
    public static void set(SysUser sysUser){
        threadLocal.set(sysUser);
    }

    //获取数据
    public static SysUser get(){
        return threadLocal.get();
    }

    // 删除数据的方法
    public static void remove() {
        threadLocal.remove();
    }
}
