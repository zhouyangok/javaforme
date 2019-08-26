package com.crazyang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crazyang.base.AjaxResponse;
import com.crazyang.entity.User;
import com.crazyang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 插入用户数据
     *
     * @param entity
     * @return
     */
    public AjaxResponse save(User entity) {
        userMapper.insert(entity);
        return AjaxResponse.success();
    }

    /**
     * 修改用户数据
     *
     * @param entity
     * @return
     */
    public AjaxResponse update(User entity) {
        userMapper.updateById(entity);
        return AjaxResponse.success();
    }

    /**
     * 获取用户数据list
     *
     * @return
     */
    public AjaxResponse getList(Integer pageNum, Integer pageSize) {
        Page<User> pageParam = new Page<User>(pageNum, pageSize);
        List<User> list = userMapper.iPageSelect(pageParam);

//        List<User> list = userMapper.selectByMap(map);
        return AjaxResponse.success(list);
    }

    /**
     * 根据用户id获取用户
     *
     * @param id
     * @return
     */
    public AjaxResponse getUserById(Integer id) {
        User user = userMapper.selectById(id);
        return AjaxResponse.success(user);

    }

    /**
     * 删除用户数据
     *
     * @param id
     * @return
     */
    public AjaxResponse delete(int id) {
        userMapper.deleteById(id);
        return AjaxResponse.success();
    }


}