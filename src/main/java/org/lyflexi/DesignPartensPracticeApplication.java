package org.lyflexi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/27 23:41
 */
@SpringBootApplication
@Slf4j
public class DesignPartensPracticeApplication {


    public static void main(String[] args) {
        SpringApplication.run(DesignPartensPracticeApplication.class, args);
        log.info("Hello World!");
    }

}