package com.crazyang.controller;

import com.crazyang.base.AjaxResponse;
import com.crazyang.base.ResultEnum;
import com.crazyang.base.ResultVO;
import com.crazyang.entity.User;
import com.crazyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/26 下午10:00.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 简单注册功能
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public Map<String, Object> register(String username, String password){
        userService.register(username,password);
        return ResultVO.result(ResultEnum.SUCCESS,true);
    }


    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    public AjaxResponse save(User user) {
        return userService.save(user);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @PostMapping("/update")
    public AjaxResponse update(User user) {
        return userService.update(user);
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping("/getUserList")
    public AjaxResponse getUserList(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return userService.getList(pageNum,pageSize);
    }

    /**
     * 根据用户id获取用户
     *
     * @param id
     * @return
     */
    @GetMapping("/getUserById/{id}")
    public AjaxResponse getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);

    }

    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public AjaxResponse deleteById(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
