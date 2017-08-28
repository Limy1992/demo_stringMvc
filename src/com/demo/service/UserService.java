package com.demo.service;

import com.demo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAllData();
    User selectIdData(Integer id);
    List<User> selectLikeData(String name);
    List<User> selectPagerData(Integer pager);
}
