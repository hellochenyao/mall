package com.pro.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author chenyao
 * date 2021-03-08
 */
@Data
public class MergeVo {

    private Long purchaseId;
    private List<Long> items;
}
