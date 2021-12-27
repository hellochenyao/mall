package com.pro.search.service;

import com.pro.common.to.es.SkuEsModal;

import java.io.IOException;
import java.util.List;

/**
 * @author chenyao
 * date 2021-03-10
 */
public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModal> skuEsModals) throws IOException;

}
