package com.pro.order.dao;

import com.pro.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:18:49
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
