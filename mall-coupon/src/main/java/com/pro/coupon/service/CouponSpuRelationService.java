package com.pro.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pro.common.utils.PageUtils;
import com.pro.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:29:51
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

