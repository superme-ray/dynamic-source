package com.dynamic;

import com.dynamic.core.DynamicService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@MapperScan(basePackages = "com.dynamic.dao")
@SpringBootApplication(scanBasePackages = {"com.dynamic.*"})
@Configuration
@RestController
public class DynamicSourceApplication {

    @Autowired
    DynamicService dynamicSource;

    public static void main(String[] args) {

        SpringApplication.run(DynamicSourceApplication.class, args);
    }


    @GetMapping("/run")
    public boolean saveUserInfo() throws InterruptedException {

        return dynamicSource.xaSave();
    }

}
