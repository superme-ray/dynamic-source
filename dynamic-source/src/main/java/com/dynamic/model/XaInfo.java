package com.dynamic.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (XaInfo)实体类
 *
 * @author makejava
 * @since 2022-04-19 10:12:54
 */
@Data
@TableName("xa_info")
public class XaInfo implements Serializable {
    private static final long serialVersionUID = -51065679526599089L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String xa;

    private String sha;

    private Date createTime;

    private Date updateTime;

}

