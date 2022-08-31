package com.springboot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shanlingshi
 * @since 2022-08-30
 */
@EnableMongoAuditing
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.springboot.mongodb")
public class MongoTransactionalApplication {

    public static void main(String[] args) {

        SpringApplication.run(MongoTransactionalApplication.class, args);
    }

}
