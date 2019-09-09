package com.crazyang.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName ProductEntity
 * @Description: 商品实体类
 * @Author zhouyang
 * @Date 2019/9/7 下午4:52.
 */
@Data
public class OrderEntity {

    private Integer id;
    @NotNull(message = "用户不能为空")
    private String userId;
    private Double productId;
    private Integer orderPrice;
    private String productImg;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private String remark;
}
