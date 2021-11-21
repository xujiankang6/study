package com.example.demo.controller;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * UserMapperController
 *
 * @author jiankang.xu
 * @date 2021/8/29
 */
@Controller
@RequestMapping("/mapper")
public class UserMapperController {

    @Autowired
    private UserService userService;




    @RequestMapping("/getuser/{uid}")
    @ResponseBody
    public User getUser(@PathVariable String uid){
        return userService.selectByPrimaryKey(Integer.valueOf(uid));
    }



    @RequestMapping("all")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.selectUser();
    }

}
