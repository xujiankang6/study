package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * TestMapper
 *
 * @author jiankang.xu
 * @date 2021/9/20
 */
@Mapper
public interface TestMapper {

    @Results({
            @Result(column = "uid",property = "uid"),
            @Result(column = "uname",property = "uname"),
            @Result(column = "upwd",property = "upwd")
    })
    @Select("select * from user ")
    List<User> selectUser();
}
