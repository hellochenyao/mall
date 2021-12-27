package com.pro.product.dao;

import com.pro.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性
 * 
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-06 19:18:38
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	List<Long> selectSearchAttrIds(@Param("attrIds") List<Long> attrIds);
}
