package com.pro.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.pro.common.to.es.SkuEsModal;
import com.pro.search.config.MallElasticSearchConfig;
import com.pro.search.constant.EsConstant;
import com.pro.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenyao
 * date 2021-03-10
 */
@Slf4j
@Service
public class ProductSaveServiceImpl implements ProductSaveService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public boolean productStatusUp(List<SkuEsModal> skuEsModals) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        for(SkuEsModal modal:skuEsModals){
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(modal.getSkuId().toString());
            String s = JSON.toJSONString(modal);
            indexRequest.source(s, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
         BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, MallElasticSearchConfig.COMMON_OPTIONS);
        boolean b = bulk.hasFailures();
        List<String> collect = Arrays.asList(bulk.getItems()).stream().map(item->{
            return item.getId();
        }).collect(Collectors.toList());
        log.error("商品上架：{}",collect);
        return b;
    }
}
