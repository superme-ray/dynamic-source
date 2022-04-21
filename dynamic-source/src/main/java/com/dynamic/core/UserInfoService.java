package com.dynamic.core;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dynamic.dao.UserInfoDao;
import com.dynamic.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: ray
 * @Date: 2022/4/19 10:52
 **/
@Service
@Slf4j
public class UserInfoService {


    private final UserInfoDao userInfoDao;

    public UserInfoService( UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @DS("slave")
    //@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW) 添加此注解是保证数据源的切换成功，但是不能保证调用方法内的整体事务回滚。
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
