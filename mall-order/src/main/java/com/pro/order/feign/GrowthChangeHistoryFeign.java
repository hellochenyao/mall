package com.pro.order.feign;

import com.pro.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author chenyao
 * date 2021-01-08
 */
@FeignClient("mall-member")
public interface GrowthChangeHistoryFeign {

    @RequestMapping("member/growthchangehistory/list")
    public R list(@RequestParam Map<String, Object> params);

}
