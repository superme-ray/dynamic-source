package com.sharding.xa.dao;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.xa.model.XaInfo;

/**
 * (XaInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-19 10:12:53
 */
@DS("master")
public interface XaInfoDao extends BaseMapper<XaInfo> {


}

