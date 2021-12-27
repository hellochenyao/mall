package com.pro.ware.vo;

import lombok.Data;

/**
 * @author chenyao
 * date 2021-03-08
 */
@Data
public class PurchaseItemDoneVo {

    private Long itemId;
    private Integer status;
    private String reason;

}
