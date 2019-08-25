package com.crazyang.base;

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
public class AjaxResponse {


    private Integer code;
    private String msg;
    private Object data;

    public AjaxResponse(Object data) {
        this.code = 200;
        this.msg = "成功";
        this.data = data;
    }

    public AjaxResponse() {
        this.code = 200;
        this.msg = "成功";
    }

    public static AjaxResponse success(Object data) {
        return new AjaxResponse(data);
    }

    public static AjaxResponse success() {
        return new AjaxResponse();
    }


}
