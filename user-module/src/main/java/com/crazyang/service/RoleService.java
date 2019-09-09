package com.crazyang.service;

import com.crazyang.base.AjaxResponse;
import com.crazyang.entity.Role;
import com.crazyang.mapper.RoleMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName RoleService
 * @Description: 角色服务层
 * @Author zhouyang
 * @Date 2019/9/7 下午4:05.
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取角色信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public AjaxResponse getRoleList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleList = roleMapper.getRoleList();
        return AjaxResponse.success(roleList);
    }

    /**
     * 保存角色
     *
     * @param role
     * @return
     */
    public AjaxResponse saveRole(Role role) {

        int result = roleMapper.insert(role);
        if (result > 0) {
            return AjaxResponse.success(result);
        }
        return AjaxResponse.failure();
    }

    /**
     * 根据id更新角色信息
     *
     * @param role
     * @return
     */
    public AjaxResponse updateRole(Role role) {
        role.setUpdateDate(new Date());
        int result = roleMapper.updateById(role);
        if (result > 0) {
            return AjaxResponse.success(result);
        }
        return AjaxResponse.failure();
    }

    /**
     * 根据id删除角色
     *
     * @param id
     * @return
     */
    public AjaxResponse deleteById(Integer id) {
        int result = roleMapper.deleteById(id);
        if (result > 0) {
            return AjaxResponse.success(result);
        }
        return AjaxResponse.failure();
    }
}
