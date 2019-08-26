package com.crazyang.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName MyException
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/26 下午9:43.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {

    private String code;  //异常状态码

    private String message;  //异常信息

    private String method;   //发生的方法，位置等

    private String descinfo;   //描述
}
