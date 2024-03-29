package com.crazyang.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName User
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午8:00.
 */
@Data
public class User {
    private Integer id;
    @NotNull(message = "用户名不能为空")
    private String username;
    private String password;
    private Integer age;
    private String address;
    private Date createDate;
    private Date updateDate;
}
