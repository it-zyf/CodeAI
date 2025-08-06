package com.xyy.codeai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.xyy.codeai.mapper")
public class CodeAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeAiApplication.class, args);
    }

}
