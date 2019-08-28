package com.crazyang.base.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyExceptionAdvice
 * @Description: 全局捕获异常和自定义全局捕获异常
 * @Author zhouyang
 * @Date 2019/8/26 下午9:44.
 */
@ControllerAdvice  //不指定包默认加了@Controller和@RestController都能控制
@Slf4j
//@ControllerAdvice(basePackages ="com.crazyang.controller")
public class MyExceptionAdvice {

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param myex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public Map<String,Object> myExceptionHandler(MyException myex){
        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("code",myex.getCode());
        map.put("message",myex.getMessage());
        map.put("method",myex.getMethod());
        map.put("descinfo",myex.getDescinfo());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        log.info("异常日志为：{}",map);
        return map;
    }
}
