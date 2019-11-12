package com.zdk.jbdc;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @description
 * @author: zhangDongkun
 * @date: 2019-11-12 20:39
 **/

public class LamdbTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setAge("80");
        user1.setGender("2");
        user1.setId("1");
        user1.setName("张三");

        User user2 = new User();
        user2.setAge("60");
        user2.setGender("1");
        user2.setId("1");
        user2.setName("张四");

        User user3 = new User();
        user3.setAge("80");
        user3.setGender("1");
        user3.setId("1");
        user3.setName("张五");
        User user4 = new User();
        user4.setAge("80");
        user4.setGender("1");
        user4.setId("1");
        user4.setName("张六");
        User user5 = new User();
        user5.setAge("70");
        user5.setGender("1");
        user5.setId("1");
        user5.setName("张器");
        List<User> list = Arrays.asList(user1,user2,user3,user4,user5);
        Map<String, Map<String,List<User>>> map =   list.stream().collect(Collectors.groupingBy(User::getAge,Collectors.groupingBy(User::getGender,Collectors.toList())));
        Gson gson = new Gson();

    System.err.println(gson.toJson(map));
    }
}
