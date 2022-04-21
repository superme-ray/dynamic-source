package com.sharding.xa;

import com.sharding.xa.core.XaService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.sharding.xa.*"})
@MapperScan(basePackages = {"com.sharding.xa.dao"})
@EnableDiscoveryClient
@Configuration
@RestController
public class XaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XaProducerApplication.class, args);
    }

    @Autowired
    private XaService xaService;

    @Bean
    public RestTemplate myRestTemplate() {
        return new RestTemplate();
    }


    @GetMapping("/run")
    public boolean saveUserInfo() throws InterruptedException {
        return xaService.xaSave();
    }

}
