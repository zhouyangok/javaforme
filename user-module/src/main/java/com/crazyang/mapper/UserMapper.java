package com.crazyang.mapper;

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

public interface UserMapper {

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> getUserList();

    /**
     * 通过用户名查找用户
     *
     * @param name
     * @return
     */
    @Select("SELECT * FROM user where name=#{name} and status=1")
    User getUserByName(@Param("name") String name);

    //通过username查询用户
    SelfUserDetails getUser(@Param("username") String username);

    @Select("SELECT * FROM user where id=#{id} and status=1")
    User selectById(@Param("id") Integer id);

    @Insert("INSERT INTO user(name,password,age,address,create_date,status) values(#{name},#{password},#{age},#{address},#{createDate},#{status})")
    int insert(User user);

    /**
     * 根据 id 更新用户信息
     */
    @Update("UPDATE  user SET name = #{name},age = #{age},address= #{address} WHERE id = #{id}")
    int updateById(User user);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("UPDATE user SET status = -1 WHERE id = #{id}")
    void deleteById(@Param("id") Integer id);
}
