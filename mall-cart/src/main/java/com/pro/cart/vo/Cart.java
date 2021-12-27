package com.pro.cart.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chenyao
 * date 2021-03-20
 */
@Data
public class Cart {

    private List<CartItem> items;

    private Integer countNum;

    private Integer countType;

    private BigDecimal totalAmount;

    private BigDecimal reduce = new BigDecimal("0.00");

    public Integer getCountNum(){
        int count = 0;
        if(items!=null&&items.size()>0){
            for(CartItem item:items){
                count+=item.getCount();
            }
        }
        return count;
    }

    public Integer getCountType(){
        int count = 0;
        if(items!=null&&items.size()>0){
            for(CartItem item:items){
                count+=1;
            }
        }
        return count;
    }

    public BigDecimal getTotalAmount(){
        BigDecimal amount = new BigDecimal("0");
        if(items!=null&&items.size()>0){
            for(CartItem item:items){
                //计算购物项总价
                BigDecimal totalPrice = item.getTotalPrice();
                amount = amount.add(totalPrice);
            }
        }
        //减去优惠总价
        BigDecimal subtract = amount.subtract(reduce);
        return subtract;
    }

}
