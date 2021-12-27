package com.pro.search.vo;

import lombok.Data;

import java.util.List;

/**
 * @author chenyao
 * date 2021-03-15
 */
@Data
public class SearchParam {

    private String keyword;
    private String catalog3Id;

    private String sort;
    private Integer hasStock;
    private String skuPrice;
    private List<Long> brandId;
    private List<String> attrs;
    private Integer pageNum = 1;
    private String _queryString;

}
