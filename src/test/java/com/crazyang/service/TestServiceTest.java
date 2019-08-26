package com.crazyang.service;

import com.crazyang.Java2019ApplicationTests;
import com.crazyang.base.AjaxResponse;
import com.crazyang.base.exception.MyException;
import com.crazyang.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @ClassName TestServiceTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午10:22.
 */
@Component
public class TestServiceTest extends Java2019ApplicationTests {

    @Autowired
    private UserService testService;

    @Test
    public void save() throws Exception {
        User entity = new User();
//        entity.setId(4);

        for(int i =5;i<10000;i++){
            entity.setId(i);
            entity.setAge(25);
            entity.setName("mike"+i);
            entity.setAddress("beijing");
            Date date = new Date();
            entity.setCreateDate(date);
            AjaxResponse ar = testService.save(entity);
            System.out.println(ar.toString());
        }

    }

    @Test
    public void update() throws Exception {
        User entity = new User();
        entity.setId(4);
        entity.setName("mike");
        Date date = new Date();
        entity.setUpdateDate(date);
        AjaxResponse ar = testService.update(entity);
        System.out.println(ar.toString());
    }

    @Test
    public void getList() throws Exception {
//        AjaxResponse ajaxResponse = testService.getList();
//        List<User> entities = (List<User>) ajaxResponse.getData();
//        entities.forEach(o -> {
//            System.out.println(o.getName() + ", " + o.getCreateDate().getTime());
//        });
    }

    @Test
    public void delete() throws Exception {
        AjaxResponse ajaxResponse = testService.delete(4);
        System.out.println(ajaxResponse.toString());
    }

    @Test
    public void testException() throws Exception{
            String name =  "";
            if(StringUtils.isEmpty(name)){
                throw new MyException("1001","empty","/API/getUserName","在获取用户名字的时候为空");
            }
    }

}