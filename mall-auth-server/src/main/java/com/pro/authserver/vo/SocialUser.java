package com.pro.authserver.vo;

import lombok.Data;

/**
 * @author chenyao
 * date 2021-03-19
 */
@Data
public class SocialUser {

    private String access_token;
    private String remind_in;
    private long expires_in;
    private String uid;
    private String isRealName;

}
