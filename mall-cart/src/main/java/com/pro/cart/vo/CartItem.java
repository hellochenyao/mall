package com.pro.cart.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chenyao
 * date 2021-03-20
 */
@Data
public class CartItem {

    private Long skuId;

    private Boolean check = false;

    private String title;

    private String image;

    private List<String> skuAttr;

    private BigDecimal price;

    private Integer count;

    private BigDecimal totalPrice;

    public BigDecimal getTotalPrice(){
        return this.price.multiply(new BigDecimal("" + this.count));
    }

}
