package org.wzj.log.service;

import org.wzj.spzx.model.entity.system.SysOperLog;

public interface AsyncOperLogService {
    void saveSysOperLog(SysOperLog sysOperLog) ;
}
