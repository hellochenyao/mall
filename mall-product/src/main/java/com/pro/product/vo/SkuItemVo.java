package com.pro.product.vo;

import com.pro.product.entity.SkuImagesEntity;
import com.pro.product.entity.SkuInfoEntity;
import com.pro.product.entity.SpuInfoDescEntity;
import lombok.Data;

import java.util.List;

/**
 * @author chenyao
 * date 2021-03-17
 */
@Data
public class SkuItemVo {
    private SkuInfoEntity info;
    private boolean hasStock = true;
    private List<SkuImagesEntity> images;
    private List<SkuItemSaleAttrVo> saleAttr;
    private SpuInfoDescEntity desp;
    private List<SpuItemAttrGroupVo> groupAttrs;
}
