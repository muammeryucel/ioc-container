package com.company;

import com.company.config.ApplicationConfiguration;
import com.company.foo.Foo;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext appContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        appContext.registerShutdownHook();

        JdbcTemplate jdbcTemplate = appContext.getBean(JdbcTemplate.class);

        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES";
        RowCallbackHandler handler = rs-> System.out.println(rs.getString(1));
        jdbcTemplate.query(sql, handler);

        jdbcTemplate.update("drop table foo if exists");

        jdbcTemplate.update("create table foo(id bigint, name varchar(255))");

        jdbcTemplate.update("insert into foo values(?,?)", 1, "test");

        RowMapper<Foo> fooRowMapper = (rs, rowNum)->new Foo(rs.getLong(1), rs.getString(2));
        Foo foo = jdbcTemplate.queryForObject("select * from foo where id=?", fooRowMapper, 1);
        System.out.println(foo);

        jdbcTemplate.update("update foo set name=? where id=?", "test123", 1);

        jdbcTemplate.update("delete from foo where id=?",1);
    }

}
