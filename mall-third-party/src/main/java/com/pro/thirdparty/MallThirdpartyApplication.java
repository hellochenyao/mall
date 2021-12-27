package com.pro.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenyao
 * date 2021-03-01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MallThirdpartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallThirdpartyApplication.class,args);
    }

}
