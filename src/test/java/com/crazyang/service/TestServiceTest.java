package com.crazyang.service;

import com.crazyang.Java2019ApplicationTests;
import com.crazyang.base.AjaxResponse;
import com.crazyang.entity.TestEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName TestServiceTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午10:22.
 */
@Component
public class TestServiceTest extends Java2019ApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    public void save() throws Exception {
        TestEntity entity = new TestEntity();
        entity.setId(4);
        entity.setAge(25);
        entity.setName("mike");
        entity.setAddress("beijing");
        Date date = new Date();
        entity.setCreateDate(date);
        AjaxResponse ar = testService.save(entity);
        System.out.println(ar.toString());
    }

    @Test
    public void update() throws Exception {
        TestEntity entity = new TestEntity();
        entity.setId(4);
        entity.setName("mike");
        Date date = new Date();
        entity.setUpdateDate(date);
        AjaxResponse ar = testService.update(entity);
        System.out.println(ar.toString());
    }

    @Test
    public void getList() throws Exception {
        AjaxResponse ajaxResponse = testService.getList();
        List<TestEntity> entities = (List<TestEntity>) ajaxResponse.getData();
        entities.forEach(o -> {
            System.out.println(o.getName() + ", " + o.getCreateDate().getTime());
        });
    }

    @Test
    public void delete() throws Exception {
        AjaxResponse ajaxResponse = testService.delete(4);
        System.out.println(ajaxResponse.toString());
    }

}