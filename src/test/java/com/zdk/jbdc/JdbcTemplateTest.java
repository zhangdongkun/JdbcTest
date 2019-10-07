package com.zdk.jbdc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @description jdbcTemplate
 * @author: zhangDongkun
 * @date: 2019-05-27 20:56
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {
    String sql = "select 1 from dual";
    String sql_create = "create table t_user(user_id int auto_increment primary key, user_name varchar(60))";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    public void exeTest(){
       this.jdbcTemplate.execute(sql_create);
    }

    @Test
    public void addTest(){
        String sql = "Insert into t_user(user_name)values(?,?)";
        Object[]params = {"张东昆",100};
        jdbcTemplate.update(sql,params,new int []{Types.VARCHAR,Types.INTEGER});


    }

    @Test
    public void queryTest(){
        String sql ="select user_name,age from t_user where user_id = ?";
        jdbcTemplate.query(sql, new Object[]{1}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("user_name"));
            }
        });
        jdbcTemplate.query(sql, new Object[]{1}, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println(rs.getString("user_name"));
                return  rs.getString("user_name");
            }
       });

    }


}
