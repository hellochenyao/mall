package com.pro.ware.service.impl;

import com.pro.common.utils.R;
import com.pro.ware.feign.ProductFeignService;
import com.pro.ware.vo.SkuHasStockVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pro.common.utils.PageUtils;
import com.pro.common.utils.Query;

import com.pro.ware.dao.WareSkuDao;
import com.pro.ware.entity.WareSkuEntity;
import com.pro.ware.service.WareSkuService;
import org.springframework.transaction.annotation.Transactional;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Autowired
    private WareSkuDao wareSkuDao;
    @Autowired
    private ProductFeignService productFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<WareSkuEntity> queryWrapper = new QueryWrapper<>();
        String skuId = (String)params.get("skuId");
        if(!StringUtils.isEmpty(skuId)){
            queryWrapper.eq("sku_id",skuId);
        }
        String wareId = (String)params.get("wareId");
        if(!StringUtils.isEmpty(wareId)){
            queryWrapper.eq("ware_id",wareId);
        }
        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {
       List<WareSkuEntity> entities = wareSkuDao.selectList(new QueryWrapper<WareSkuEntity>().eq("sku_id",skuId).eq("ware_id",wareId));
       if(entities==null||entities.size()==0){
           WareSkuEntity skuEntity = new WareSkuEntity();
           skuEntity.setSkuId(skuId);
           skuEntity.setStock(skuNum);
           skuEntity.setWareId(wareId);
           skuEntity.setStockLocked(0);
           skuEntity.setSkuName("");
           try{
               R info = productFeignService.info(skuId);
               Map<String,Object> data = (Map<String,Object>) info.get("skuInfo");
               if(info.getCode()==0){
                   skuEntity.setSkuName((String)data.get("skuName"));
               }
           }catch (Exception e){

           }
           wareSkuDao.insert(skuEntity);
       }else {
           wareSkuDao.addStock(skuId,wareId,skuNum);
       }
    }

    @Override
    public List<SkuHasStockVo> getSkusHasStock(List<Long> skuIds) {
        List<SkuHasStockVo> collect = skuIds.stream().map(sku->{
            SkuHasStockVo vo = new SkuHasStockVo();
            Long count = baseMapper.getSkuStock(sku);
            vo.setSkuId(sku);
            vo.setHasStock(count==null?false:count>0);
            return vo;
        }).collect(Collectors.toList());
        return collect;
    }
}