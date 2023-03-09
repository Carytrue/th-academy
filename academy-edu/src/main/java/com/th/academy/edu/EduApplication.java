package com.th.academy.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author th
 * @date 2023/3/8 22:57
 */
@SpringBootApplication
@ComponentScan("com.th.academy")
@MapperScan("com.th.academy.edu.mapper")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
