package com.pro.coupon.dao;

import com.pro.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:29:52
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
