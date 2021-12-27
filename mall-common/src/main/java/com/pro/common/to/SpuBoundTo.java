package com.pro.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chenyao
 * date 2021-03-07
 */
@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
