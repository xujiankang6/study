package com.example.demo.service;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Param;
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


    /**
     * 基于注解返回结果
     *
     * @return
     */
    List<User> selectUser();


    /**
     * 实现分页第二种方式
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> selectByPageNumSize(
            int pageNum,
            int pageSize);


}
