package com.example.demo.service.impl;

import com.example.demo.mapper.TestMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author jiankang.xu
 * @date 2021/8/29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestMapper testMapper;

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectUser() {
        return testMapper.selectUser();
    }
}
