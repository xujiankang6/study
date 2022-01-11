package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserPlusMapperTest
 *
 * @author jiankang.xu
 * @date 2021/12/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserPlusMapperTest {

    @Autowired
    private UserPlusMapper userMapper;

    @Test
    public void testSelect() {
        LambdaQueryWrapper<User> userQueryWrapper = Wrappers.<User>lambdaQuery()
                .likeRight(User::getUname, "梅")
                .or(wq -> wq.lt(User::getUid, 30)
                        .gt(User::getUpwd, 20)
                        .isNotNull(User::getUid));
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);

    }

}