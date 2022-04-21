package com.sharding.xa.core;

import com.sharding.xa.dao.UserInfoDao;
import com.sharding.xa.model.UserInfo;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ray
 * @Date: 2022/4/19 11:04
 **/
@Service
public class XaClientService {


    private final UserInfoDao userInfoDao;

    public XaClientService(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Transactional(rollbackFor = Exception.class)
    //@ShardingTransactionType(TransactionType.XA)
    public boolean xaSaveUserInfo(UserInfo userInfo) {
        return userInfoDao.insert(userInfo) > 0;
    }

}
