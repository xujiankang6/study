package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.mapper.UserPlusMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.VerifyUtils;
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
    @Autowired
    UserPlusMapper userPlusMapper;


    @RequestMapping("/getuser/{uid}")
    @ResponseBody
    public User getUser(@PathVariable String uid) {
        return userService.selectByPrimaryKey(Integer.valueOf(uid));
    }

    @RequestMapping("/getuser2/{uid}")
    @ResponseBody
    public List<User> getUser2(@PathVariable String uid) {
        LambdaQueryWrapper<User> userQueryWrapper = Wrappers.<User>lambdaQuery()
                .select(User::getUid,User::getUname)
                .nested(wq -> wq.eq(User::getUid, 1)
                        .or()
                        .eq(User::getUid, 2))
                .likeRight(User::getUname, "test").orderByDesc(User::getUid,User::getUname)
                .groupBy(User::getUid,User::getUname);
        String sqlSelect = userQueryWrapper.getSqlSelect();
        List<User> users = userPlusMapper.selectList(userQueryWrapper);
        return users;
    }

    @RequestMapping("/getuser3/{uid}")
    @ResponseBody
    public List<User> getUser3(@PathVariable String uid) {
        LambdaQueryWrapper<User> userQueryWrapper = Wrappers.<User>lambdaQuery()
                .select(User::getUid,User::getUname)
                .nested(wq -> wq.eq(User::getUid, 1)
                        .or()
                        .eq(User::getUid, 2))
                .likeRight(User::getUname, "test").orderByDesc(User::getUid,User::getUname)
                .groupBy(User::getUid,User::getUname);
        String sqlSelect = userQueryWrapper.getSqlSelect();
        List<User> users = userPlusMapper.selectList(userQueryWrapper);
        return users;
    }

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
