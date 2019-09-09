package com.crazyang.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName AjaxResponse
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午10:11.
 */
@Data
@AllArgsConstructor
public class AjaxResponse<T> {


    private Integer code;
    private String msg;
    private T data;

    public AjaxResponse(T data) {
        this.code = 200;
        this.msg = "成功";
        this.data = data;
    }

    public AjaxResponse() {
        this.code = 200;
        this.msg = "成功";
    }

    public AjaxResponse(Integer code, String msg) {
        this.code = 200;
        this.msg = "成功";
    }

    public static AjaxResponse success(Object data) {
        return new AjaxResponse(data);
    }

    public static AjaxResponse success() {
        return new AjaxResponse();
    }

    public static AjaxResponse failure() {
        return new AjaxResponse(ResultEnum.FAILURE);
    }

    public static AjaxResponse failure(String msg) {
        return new AjaxResponse(ResultEnum.FAILURE.getCode(),msg);
    }
}
