package com.zdk.jbdc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloContoller {
    @Autowired
    JdbcTemplate jdbcTemplate;
     @GetMapping("/hello")
    public List<Map<String, Object>> hello(){
         List<Map<String, Object>>  list =  jdbcTemplate.queryForList("select * from  ibx_branch_info ");
         return  list;

    }
}
