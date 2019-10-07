package com.zdk.jbdc;

import com.zdk.jbdc.service.SpringBootCacheTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JbdcApplicationTests {
    @Autowired
    SpringBootCacheTest springBootCacheTest ;

    @Test
    public void cacheTest(){
        String id = "001";
        long start = System.currentTimeMillis();
        System.out.println(springBootCacheTest.testCache(id));
        long end = System.currentTimeMillis();
        System.out.println("第一次耗时：----" +(start-end));


        long start2 = System.currentTimeMillis();
        System.out.println(springBootCacheTest.testCache(id));
        long end2 = System.currentTimeMillis();
        System.out.println("第二次耗时：----" +(start2-end2));

        long start3 = System.currentTimeMillis();
        springBootCacheTest.updateCache(id);
        long end3 = System.currentTimeMillis();
        System.out.println("更新耗时：----" +(start2-end2));

        long start4 = System.currentTimeMillis();
        System.out.println(springBootCacheTest.testCache(id));
        long end4 = System.currentTimeMillis();
        System.out.println("更新后取值：----" +(start4-end4));

        springBootCacheTest.removeCache(id);


        long start5 = System.currentTimeMillis();
        System.out.println(springBootCacheTest.testCache(id));
        long end5 = System.currentTimeMillis();
        System.out.println("删除后取值：----" +(start5-end5));



    }
    @Test
    public void lambdaTest () {
        List<String> list = Arrays.asList("a1","b222222","c","d","e");
        //list.forEach(a->System.out.println(a));
        list.forEach(System.out::println);

        List<String> collected = new ArrayList<>();

        list.stream().map((a)->a+1).forEach((a)->System.out.println(a));       //lambda表达式代理 匿名函数


        List<Integer> list2 = Arrays.asList(1,2,3,4,100,123);
        list2.forEach((a)->System.out.println());

    }


    public String getUser(User u) {
        return Optional.ofNullable(u).map(u2->u2.getName()).map(u3->u.getId()).get();

    }



    }



