package com.sharding.xa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author makejava
 * @since 2022-04-19 10:13:35
 */
@Data
@TableName("user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 561779214152334212L;


    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    
    private String username;
    
    private String pwd;
    
    private Date createTime;
    
    private Date updateTime;


}

