package com.dynamic.core;

import com.dynamic.dao.XaInfoDao;
import com.dynamic.model.XaInfo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: ray
 * @Date: 2022/4/21 16:15
 **/
@Service
public class XaInfoService {

    private final XaInfoDao xaInfoDao;

    public XaInfoService(XaInfoDao xaInfoDao) {
        this.xaInfoDao = xaInfoDao;

    }


    //@Transactional(rollbackFor = Exception.class)
    public boolean saveXaInfo() throws InterruptedException {
        XaInfo xaInfo = new XaInfo();
        xaInfo.setSha("xa-test");
        xaInfo.setXa("xa");
        xaInfo.setCreateTime(new Date());
        xaInfo.setUpdateTime(new Date());
        //int a = 10 / 0;
        return xaInfoDao.insert(xaInfo) > 0;
    }

}
