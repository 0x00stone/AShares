package com.revers.ashares;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource(encoding = "UTF-8", value = {"classpath:application.properties"})
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableScheduling
@Slf4j
public class ASharesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ASharesApplication.class, args);
    }

}
