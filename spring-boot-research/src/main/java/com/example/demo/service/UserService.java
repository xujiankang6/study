package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService
 *
 * @author jiankang.xu
 * @date 2021/8/29
 */

public interface UserService {

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    List<User> selectUser();
}
