package com.crazyang.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName TestEntity
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午8:00.
 */
@Data
@TableName("test2019")
public class TestEntity {

    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Date createDate;
    private Date updateDate;
}
