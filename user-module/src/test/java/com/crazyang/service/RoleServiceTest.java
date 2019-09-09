package com.crazyang.service;

import com.crazyang.Java2019ApplicationTests;
import com.crazyang.base.AjaxResponse;
import com.crazyang.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @ClassName RoleServiceTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/9/7 下午4:08.
 */
@Component
@Slf4j
public class RoleServiceTest extends Java2019ApplicationTests {
    @Autowired
    private RoleService roleService;

    @Test
    public void saveRole() throws Exception {
        Role role = new Role();
        role.setRoleName("普通用户");
        role.setCreateDate(new Date());
        AjaxResponse response = roleService.saveRole(role);
        log.info("返回结果", response);
    }

    @Test
    public void getRoleList(){
        AjaxResponse response  = roleService.getRoleList(1,10);
        log.info("",response);
    }

}