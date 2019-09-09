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
public class ProductEntity {

    private Integer id;
    @NotNull(message = "商品名不能为空")
    private String productName;
    private Double productPrice;
    private Integer productNumber;
    private String describe;
    private String productImg;
    private Date createDate;
    private Date updateDate;
    private Integer status;
}
