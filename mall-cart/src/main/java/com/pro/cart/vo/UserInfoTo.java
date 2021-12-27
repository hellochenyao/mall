package com.pro.cart.vo;

import lombok.Data;

/**
 * @author chenyao
 * date 2021-03-20
 */
@Data
public class UserInfoTo {

    private Long userId;

    private String userKey;

    private boolean tempUser = false;

}
