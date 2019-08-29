package com.crazyang.service;

import com.crazyang.base.AjaxResponse;
import com.crazyang.entity.User;
import com.crazyang.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

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

    public void register(String username,String password){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        bCryptPasswordEncoder.encode(password);

    }

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
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.getUserList();

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
     * 根据用户name获取用户
     *
     * @param name
     * @return
     */
    public AjaxResponse getUserByName(String name){
        User user = userMapper.getUserByName(name);
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
