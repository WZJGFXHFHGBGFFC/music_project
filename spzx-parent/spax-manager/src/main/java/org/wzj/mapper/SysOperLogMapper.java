package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.entity.system.SysOperLog;

@Mapper
public interface SysOperLogMapper {
    void insert(SysOperLog sysOperLog);
}
