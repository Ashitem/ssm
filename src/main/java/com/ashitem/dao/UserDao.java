package com.ashitem.dao;

import com.ashitem.domain.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    List<User> findAll();

    void insertUser(User user);

    void deleteUser(int id);

    void updateUser(User user);
}
