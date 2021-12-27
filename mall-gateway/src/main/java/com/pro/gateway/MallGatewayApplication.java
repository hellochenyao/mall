package com.pro.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyao
 * date 2021-02-25
 */
@EnableDiscoveryClient
@RestController
@RefreshScope
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MallGatewayApplication {

    @Value("${a:aa}")
    private String a;
    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class);
    }

    @RequestMapping(value = "/t",method = RequestMethod.GET)
    public void getA(){
        System.out.println(a);
    }

}
