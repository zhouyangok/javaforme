package com.crazyang.service;

import com.crazyang.base.AjaxResponse;
import com.crazyang.entity.TestEntity;
import com.crazyang.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestServcie
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午10:10.
 */
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public AjaxResponse save(TestEntity entity) {
        testMapper.insert(entity);
        return AjaxResponse.success();
    }

    public AjaxResponse update(TestEntity entity) {
        testMapper.updateById(entity);
        return AjaxResponse.success();
    }

    public AjaxResponse getList() {
        Map map = new HashMap();
        List<TestEntity> list = testMapper.selectByMap(map);
        return AjaxResponse.success(list);
    }

    public AjaxResponse delete(int id) {
        testMapper.deleteById(id);
        return AjaxResponse.success();
    }


}
