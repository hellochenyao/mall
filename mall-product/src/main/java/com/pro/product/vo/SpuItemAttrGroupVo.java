package com.pro.product.vo;

import lombok.Data;

import java.util.List;

/**
 * @author chenyao
 * date 2021-03-17
 */
@Data
public class SpuItemAttrGroupVo {
    private String groupName;
    private List<Attr> attrs;
}
