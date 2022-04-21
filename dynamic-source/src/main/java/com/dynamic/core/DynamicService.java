package com.dynamic.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ray
 * @Date: 2022/4/21 16:17
 **/
@Service
public class DynamicService {

    private UserInfoService userInfoService;
    private XaInfoService xaInfoService;

    @Autowired
    public void autowiredService(UserInfoService userInfoService, XaInfoService xaInfoService) {
        this.userInfoService = userInfoService;
        this.xaInfoService = xaInfoService;
    }

    /**
     * 1. 不添加事务保证数据源的切换成功
     * 2. 添加了事务能保证该方法内的事务一直，但是数据源切换失败
     *
     * @return
     * @throws InterruptedException
     */
    public boolean xaSave() throws InterruptedException {
        userInfoService.saveUserInfo();
        return xaInfoService.saveXaInfo();
    }


}
