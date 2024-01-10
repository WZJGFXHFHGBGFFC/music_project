package org.wzj.service;

import org.springframework.stereotype.Service;
import org.wzj.spzx.model.dto.order.OrderStatisticsDto;
import org.wzj.spzx.model.vo.order.OrderStatisticsVo;

@Service
public interface OrderInfoService {
    //统计查询
    OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}
