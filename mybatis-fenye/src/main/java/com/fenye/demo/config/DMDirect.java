package com.fenye.demo.config;

import com.github.pagehelper.Page;
import com.github.pagehelper.dialect.AbstractDialect;
import com.github.pagehelper.dialect.helper.MySqlDialect;
import com.github.pagehelper.page.PageAutoDialect;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

/**
 * DMDirect
 *
 * @author jiankang.xu
 * @date 2021/11/16
 */
@Component
public class DMDirect extends MySqlDialect {

    static {
        PageAutoDialect.registerDialectAlias("custom",MySqlDialect.class);
    }


    @Override
    public String getPageSql(String sql, Page page, CacheKey pageKey) {
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 14);
        sqlBuilder.append(sql);
        if (page.getStartRow() == 0) {
            sqlBuilder.append(" LIMIT ? ");
        } else {
            sqlBuilder.append(" LIMIT ?, ? ");
        }

        pageKey.update(page.getPageSize());
        return sqlBuilder.toString();
    }
}
