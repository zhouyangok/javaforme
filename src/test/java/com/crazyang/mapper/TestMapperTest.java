package com.crazyang.mapper;

import com.crazyang.Java2019ApplicationTests;
import com.crazyang.entity.TestEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName TestMapperTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午8:02.
 */
@Component
public class TestMapperTest  extends Java2019ApplicationTests{

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test(){
        System.out.println(("----- selectAll method test ------"));
        List<TestEntity> testEntityList = testMapper.selectList(null);
        Assert.assertEquals(5, testEntityList.size());
        testEntityList.forEach(System.out::println);
    }

}