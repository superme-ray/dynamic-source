package com.sharding.xa.core;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sharding.xa.dao.UserInfoDao;
import com.sharding.xa.dao.XaInfoDao;
import com.sharding.xa.model.UserInfo;
import com.sharding.xa.model.XaInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @Author: ray
 * @Date: 2022/4/19 10:52
 **/
@Component
@Slf4j
public class XaService {

    private final XaInfoDao xaInfoDao;
    private final UserInfoDao userInfoDao;
    private final RestTemplate restTemplate;

    public XaService(XaInfoDao xaInfoDao, UserInfoDao userInfoDao, RestTemplate restTemplate) {
        this.xaInfoDao = xaInfoDao;
        this.userInfoDao = userInfoDao;
        this.restTemplate = restTemplate;
    }

    //@Transactional(rollbackFor = Exception.class)
    //@ShardingTransactionType(TransactionType.XA)

    public boolean xaSave() throws InterruptedException {
        //boolean result = restTemplate.postForObject("http://192.168.10.20:9998/xa", userInfo, Boolean.class, "");
        //log.debug("========================");
        //log.info("result: " + result);
        //log.debug("========================");
        saveUserInfo();
        return saveXaInfo();

    }

    //@DS("master")
    @Transactional(rollbackFor = Exception.class)
    public boolean saveXaInfo() throws InterruptedException {
        Thread.sleep(6000);
        XaInfo xaInfo = new XaInfo();
        xaInfo.setSha("xa-test");
        xaInfo.setXa("xa");
        xaInfo.setCreateTime(new Date());
        xaInfo.setUpdateTime(new Date());
        int a = 10 / 0;
        return xaInfoDao.insert(xaInfo) > 0;
    }


    //@DS("slave")
    @Transactional(rollbackFor = Exception.class)
    public void saveUserInfo() {
        //xa test
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user-test");
        userInfo.setPwd("123456");
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        userInfoDao.insert(userInfo);
    }
}
