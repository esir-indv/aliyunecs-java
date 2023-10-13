package com.scrcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AliyunecsJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliyunecsJavaApplication.class, args);
    }

}
