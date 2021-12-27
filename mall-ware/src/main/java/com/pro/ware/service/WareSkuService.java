package com.pro.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pro.common.utils.PageUtils;
import com.pro.ware.entity.WareSkuEntity;
import com.pro.ware.vo.SkuHasStockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:45:24
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId,Long wareId,Integer skuNum);

    List<SkuHasStockVo> getSkusHasStock(List<Long> skuIds);
}

