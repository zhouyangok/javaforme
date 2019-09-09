package com.crazyang.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName Role
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/9/7 下午3:53.
 */
@Data
public class Role {

    private Integer id;
    @NotNull(message = "用户名不能为空")
    private String roleName;
    private Date createDate;
    private Date updateDate;
    private Integer status;
}
