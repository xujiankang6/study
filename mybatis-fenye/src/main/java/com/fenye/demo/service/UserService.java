package com.fenye.demo.service;

import com.fenye.demo.model.User;

import java.util.List;

/**
 * UserService
 *
 * @author jiankang.xu
 * @date 2021/8/29
 */

public interface UserService {




    /**
     * 基于注解返回结果
     *
     * @return
     */
    List<User> selectUser();


    /**
     * 实现分页第二种方式
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> selectByPageNumSize(
            int pageNum,
            int pageSize);


}
