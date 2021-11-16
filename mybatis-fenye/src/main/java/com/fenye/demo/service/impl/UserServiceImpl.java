package com.fenye.demo.service.impl;

import com.fenye.demo.mapper.my.TestMapper;
import com.fenye.demo.model.User;
import com.fenye.demo.service.UserService;
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
    private TestMapper testMapper;


    @Override
    public List<User> selectUser() {
        return testMapper.selectUser();
    }

    @Override
    public List<User> selectByPageNumSize(int pageNum, int pageSize) {
        return testMapper.selectByPageNumSize(pageNum, pageSize);
    }
}
