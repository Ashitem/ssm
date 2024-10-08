package com.ashitem.service.impl;

import com.ashitem.common.PageResult;
import com.ashitem.dao.UserDao;
import com.ashitem.domain.User;
import com.ashitem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public PageResult findByPage(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userDao.findAll();
        PageInfo pageInfo = new PageInfo<>(userList);
        PageResult pageResult = new PageResult<>(pageInfo.getPageNum(), pageInfo.getPageSize(), (int) pageInfo.getTotal(), userList);
        return pageResult;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void test() {
        userDao.insertUser(new User(null, "xiaoming", 20));
//        System.out.println(1 / 0);
        userDao.insertUser(new User(null, "xiaozhang", 20));
    }//phpMyAdmin中的表默认为MyISAM不支持事务应将其改为InnoDB！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
}
