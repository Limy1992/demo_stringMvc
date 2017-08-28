package com.demo.service;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> selectAllData() {
        return userMapper.queryUserAllData();
    }

    @Override
    public User selectIdData(Integer id) {
        return userMapper.queryUserId(id);
    }

    @Override
    public List<User> selectLikeData(String name) {
        return userMapper.queryWhereData(name);
    }

    @Override
    public List<User> selectPagerData(Integer pager) {
        return userMapper.queryPagerData(pager);
    }
}
