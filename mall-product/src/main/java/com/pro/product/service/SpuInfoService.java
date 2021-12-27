package com.pro.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pro.common.utils.PageUtils;
import com.pro.product.entity.SpuInfoDescEntity;
import com.pro.product.entity.SpuInfoEntity;
import com.pro.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-06 19:18:37
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    void saveSpuInfoDesc(SpuInfoDescEntity descEntity);

    PageUtils queryPageByCondition(Map<String,Object> params);

    void up(Long spuId);
}

