package com.fenye.demo.mapper.my;

import com.fenye.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * TestMapper
 *
 * @author jiankang.xu
 * @date 2021/9/20
 */
@Mapper
public interface TestMapper {

    @Results(id = "getusers", value = {
            @Result(column = "uid", property = "uid"),
            @Result(column = "uname", property = "uname"),
            @Result(column = "upwd", property = "upwd")
    })
    @Select("select * from user ")
    List<User> selectUser();


    /**
     * 实现分页功能
     */

    @ResultMap("getusers")
    @Select("select * from user ")
    List<User> selectByPageNumSize(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize);

}
