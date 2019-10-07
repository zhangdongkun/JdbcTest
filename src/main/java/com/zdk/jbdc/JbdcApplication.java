package com.zdk.jbdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.zdk.jbdc.repository")
@EntityScan("com.zdk.jbdc.entity")
//开启缓存
@EnableCaching
public class JbdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JbdcApplication.class, args);
    }

}
