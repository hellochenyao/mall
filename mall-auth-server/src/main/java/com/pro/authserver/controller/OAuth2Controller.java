package com.pro.authserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.pro.authserver.feign.MemberFeignService;
import com.pro.common.constant.AuthServerConstant;
import com.pro.common.vo.MemberRespVo;
import com.pro.authserver.vo.SocialUser;
import com.pro.common.utils.HttpUtils;
import com.pro.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyao
 * date 2021-03-19
 */
@Slf4j
@Controller
public class OAuth2Controller {

    @Autowired
    private MemberFeignService memberFeignService;

    @GetMapping("/oauth2.0/weibo/success")
    public String weibo(@RequestParam("code") String code, HttpSession session) throws Exception {
        //1.code换区token
        Map<String,String> map = new HashMap<>();
        map.put("client_id","");
        map.put("client_secret","");
        map.put("grant_type","authorization_code");
        map.put("redirect_uri","http://127.0.0.1:20000/oauth2.0/weibo/success");
        map.put("code",code);
        HttpResponse response = HttpUtils.doPost("api.weibo.com","/oauth2/access_token","post",null,null,map);
        if(response.getStatusLine().getStatusCode() == 200){
           String json = EntityUtils.toString(response.getEntity());
           SocialUser socialUser = JSON.parseObject(json,SocialUser.class);
            R oauthlogin = memberFeignService.oauthlogin(socialUser);
            if(oauthlogin.getCode()==0){
                MemberRespVo data = oauthlogin.getData("data",new TypeReference<MemberRespVo>(){});
                log.info("登录成功：用户：{}",data.toString());
                session.setAttribute(AuthServerConstant.LOGIN_USER,data);
                return "redirect:http://127.0.0.1:10007";
            }else{
                return "redirect:http://127.0.0.1:20000/login.html";
            }
        }else {
            return "redirect://127.0.0.1:20000/login.html";
        }
    }

}
