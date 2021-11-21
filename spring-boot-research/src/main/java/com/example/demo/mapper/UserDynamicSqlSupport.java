package com.example.demo.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final User user = new User();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> uid = user.uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> uname = user.uname;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> upwd = user.upwd;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class User extends SqlTable {
        public final SqlColumn<Integer> uid = column("uid", JDBCType.INTEGER);

        public final SqlColumn<String> uname = column("uname", JDBCType.VARCHAR);

        public final SqlColumn<String> upwd = column("upwd", JDBCType.VARCHAR);

        public User() {
            super("user");
        }
    }
}