package com.crazyang.mapper;

import com.crazyang.entity.Role;
import com.crazyang.entity.SelfUserDetails;
import com.crazyang.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午8:01.
 */

public interface RoleMapper {

    /**
     * 查询所有角色信息
     */
    @Select("SELECT * FROM role where status = 0")
    List<Role> getRoleList();

    /**
     * 插入角色
     * @param role
     * @return
     */
    @Insert("INSERT INTO role(role_name,create_date,status) values(#{roleName},#{createDate},#{status})")
    int insert(Role role);

    /**
     * 根据 id 更新角色信息
     */
    @Update("UPDATE  role SET role_name = #{roleName},update_time=#{updateTime} WHERE id = #{id}")
    int updateById(Role role);

    /**
     * 根据 id 删除角色信息
     */
    @Delete("UPDATE role SET status = -1 WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);
}
