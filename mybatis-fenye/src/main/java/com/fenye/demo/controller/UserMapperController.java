package com.fenye.demo.controller;

import com.fenye.demo.model.User;
import com.fenye.demo.service.UserService;
import com.fenye.demo.util.VerifyUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @Autowired
    private VerifyUtils verifyUtils;





    /**
     * 实现分页第一种方式
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("all")
    @ResponseBody
    public PageInfo<User> getAllUser(@Param("pageNum") String pageNum, @Param("pageSize") String pageSize) {
        if (!verifyUtils.isNumber(pageNum)) {
            pageNum = "1";
        }
        if (!verifyUtils.isNumber(pageSize)) {
            pageSize = "10";
        }
        PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
        List<User> users = userService.selectUser();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }


    @RequestMapping("all2")
    @ResponseBody
    public PageInfo<User> getAllUser2(@Param("pageNum") String pageNum, @Param("pageSize") String pageSize) {
        if (!verifyUtils.isNumber(pageNum)) {
            pageNum = "1";
        }
        if (!verifyUtils.isNumber(pageSize)) {
            pageSize = "10";
        }
        List<User> users = userService.selectByPageNumSize(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }


}
