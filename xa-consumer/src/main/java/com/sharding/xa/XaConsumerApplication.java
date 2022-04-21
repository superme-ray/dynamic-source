package com.sharding.xa;

import com.sharding.xa.core.XaClientService;
import com.sharding.xa.model.UserInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.sharding.xa.*"})
@MapperScan(basePackages = {"com.sharding.xa.dao"})
@EnableDiscoveryClient
@RestController
public class XaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XaConsumerApplication.class, args);
    }

    @Autowired
    private XaClientService xaClientService;

    @PostMapping("/xa")
    public boolean saveUserInfo(@RequestBody UserInfo userInfo) {
        return xaClientService.xaSaveUserInfo(userInfo);
    }

}
