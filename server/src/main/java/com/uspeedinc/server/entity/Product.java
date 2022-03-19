package com.uspeedinc.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品表
 *
 * @author kevinliu
 * @date 3/19/22 12:47 PM
 * @since v1.0.0
 */

@TableName("t_product")
@Data
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String skuNo;
    private String skuName;
}
