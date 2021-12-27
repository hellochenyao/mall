package com.pro.product.dao;

import com.pro.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-06 19:18:38
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
