package com.ashitem.service;

import com.ashitem.common.PageResult;
import com.ashitem.domain.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    List<User> findAll();

    PageResult findByPage(int pageSize, int pageNum);

    void insertUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    void test();
}
