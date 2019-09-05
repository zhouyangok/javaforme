package com.crazyang.service;

import com.crazyang.entity.SelfUserDetails;
import com.crazyang.entity.User;
import com.crazyang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CustomUserService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/8/29 下午9:41.
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SelfUserDetails user = userMapper.getUser(s);
        if(user!=null){
            Set authoritiesSet = new HashSet();
            // 模拟从数据库中获取用户角色
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");

            authoritiesSet.add(authority);
            user.setAuthorities(authoritiesSet);

        }
        return user;
    }
}
