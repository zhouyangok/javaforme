package com.crazyang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crazyang.entity.User;
import com.crazyang.vo.MyPage;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/25 下午8:01.
 */

public interface UserMapper extends BaseMapper<User> {

    List<User> myPageSelect(MyPage<User> myPage);

    List<User> iPageSelect(IPage<User> myPage);
}
