package com.demo.mapper;

import com.demo.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> queryUserAllData();
    User queryUserId(Integer uid);
    List<User> queryWhereData(String name);
    List<User> queryPagerData(Integer pager);

}
