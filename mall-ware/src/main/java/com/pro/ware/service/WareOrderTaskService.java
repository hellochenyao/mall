package com.pro.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pro.common.utils.PageUtils;
import com.pro.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:45:24
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

