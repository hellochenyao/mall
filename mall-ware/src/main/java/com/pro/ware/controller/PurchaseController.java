package com.pro.ware.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pro.ware.vo.MergeVo;
import com.pro.ware.vo.PurchaseDoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pro.ware.entity.PurchaseEntity;
import com.pro.ware.service.PurchaseService;
import com.pro.common.utils.PageUtils;
import com.pro.common.utils.R;



/**
 * 采购信息
 *
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:45:24
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }

    @PostMapping("/done")
    private R finish(@RequestBody PurchaseDoneVo doneVo){
        purchaseService.done(doneVo);
        return R.ok();
    }

    @PostMapping("/received")
    public R receive(@RequestBody List<Long> ids){
        return R.ok();
    }

    @PostMapping("/merge")
    public R merge(@RequestBody MergeVo mergeVo){
        purchaseService.mergePurchase(mergeVo);
        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/unreceive/list")
    public R unreceivelist(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnreceivePurchase(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PurchaseEntity purchase){
		purchaseService.save(purchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}