package com.zdk.jbdc.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SpringBootCacheTest {
    private static final  String cache_key="cache_key";
    @Cacheable(value=cache_key)
    public String testCache(String id) {

     return this.getId(id);

    }

    @CacheEvict(value=cache_key)
    public void removeCache(String id){
        System.out.println("删除缓存 ");
    }

     @CachePut(value=cache_key)
    public String updateCache(String id){
         System.out.println("更新缓存 ");
         return this.getId(id+"update");
    }

    private String getId(String id){
        try {
            Thread.sleep(2000);

        } catch ( InterruptedException e) {

        }



        return "hello :" +id;

    }
}
