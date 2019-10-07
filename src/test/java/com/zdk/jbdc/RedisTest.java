package com.zdk.jbdc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @description redis测试,测试存集合还是单个键值
 * 测试结果 集合的插入较快，取出两者相当
 * @author: zhangDongkun
 * @date: 2019-05-25 16:15
 **/
@RunWith(SpringRunner.class)
@SpringBootTest

public class RedisTest {
     @Autowired
      RedisTemplate redisTemplate ;
     @Test
     //测试1.对象以序列化的形式保存 耗时 3569
     public  void addTest() {
         long start = System.currentTimeMillis();

         for (int i = 0; i < 9000; i++) {
             User user = new User();
             user.setId("key"+i);
             user.setName("No." + i);

             redisTemplate.opsForValue().set(user.getId(),user);
         }


         long end = System.currentTimeMillis();

         System.err.println(end-start);

     }
    @Test
    /*模糊匹配的形式取值   测试结果 耗时 855*/
    public  void getTest() {
        long start = System.currentTimeMillis();


        Set<String> set =  redisTemplate.keys("key9*");
        for (String key : set) {
            System.out.println(redisTemplate.opsForValue().get(key));
        }


        long end = System.currentTimeMillis();

        System.err.println(end-start);


    }
    //测试1.对象以序列化的形式保存 测试结果 774
    @Test
    public  void addTestList() {
        long start = System.currentTimeMillis();
         List<User> list  = new ArrayList<>();
        for (int i = 0; i < 9000; i++) {
            User user = new User();
            user.setId("key"+i);
            user.setName("No." + i);
            list.add(user);

        }

        redisTemplate.opsForValue().set("xxx",list);

        long end = System.currentTimeMillis();

        System.err.println(end-start);

    }



    @Test
    /*取出list 中的值   测试结果 耗时 722*/
    public  void getTestList() {
        long start = System.currentTimeMillis();

        List<User> list = (List<User>) redisTemplate.opsForValue().get("xxx");
        for (User u : list) {
            if (u.getId().equals("key6000")) {

                System.err.println("got it" + u);
                long end = System.currentTimeMillis();

                System.err.println(end - start);
            }


        }

    }


}
