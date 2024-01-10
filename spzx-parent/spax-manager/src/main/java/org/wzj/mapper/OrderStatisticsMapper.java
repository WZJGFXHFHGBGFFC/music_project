package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.dto.order.OrderStatisticsDto;
import org.wzj.spzx.model.entity.order.OrderStatistics;

import java.util.List;

@Mapper
public interface OrderStatisticsMapper {

    //订单数据统计
    void insert(OrderStatistics orderStatistics);

    //统计查询
    List<OrderStatistics> selectList(OrderStatisticsDto orderStatisticsDto);
}
