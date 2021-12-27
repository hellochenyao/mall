package com.pro.product.vo;

import lombok.Data;
import sun.plugin.dom.core.Attr;

/**
 * @author chenyao
 * date 2021-03-03
 */
@Data
public class AttrRespVo extends AttrVo {

    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
