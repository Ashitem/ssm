package com.ashitem.controller;

import com.ashitem.common.PageResult;
import com.ashitem.common.ResponseResult;
import com.ashitem.domain.User;
import com.ashitem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseResult findById(@PathVariable("id") int id) {
       User user= userService.findById(id);
       if (user==null){
           return new ResponseResult<>(500,"该用户不存在");
       }
        return new ResponseResult<>(200,"查询成功",user);
    }
    @GetMapping("/user")
    public ResponseResult findAll(){
      List<User> userList= userService.findAll();
//        System.out.println(1/0);
      return new ResponseResult<>(200,"查询成功",userList);
    }
    @GetMapping("/user/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") int pageSize,@PathVariable("pageNum") int pageNum){
        PageResult pageResult =userService.findByPage(pageSize,pageNum);
        return new ResponseResult<>(200,"查询成功",pageResult);
    }
    @PostMapping("/user")
    public ResponseResult insertUser(@RequestBody User user){
       userService.insertUser(user);
        return new ResponseResult<>(200,"插入成功");
    }
    @DeleteMapping("/user/{id}")
    public ResponseResult deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseResult<>(200,"删除成功");
    }
    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseResult<>(200,"更新成功");
    }
    @RequestMapping("/user/test")
    public ResponseResult test(){
        userService.test();
        return new ResponseResult<>(200,"事务测试");
    }

}
