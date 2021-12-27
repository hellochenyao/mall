package com.pro.search.service;

import com.pro.search.vo.SearchParam;
import com.pro.search.vo.SearchResult;

/**
 * @author chenyao
 * date 2021-03-15
 */
public interface MallSearchService {

    SearchResult search(SearchParam param);

}
