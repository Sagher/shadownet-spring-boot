package com.shadow.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.shadow.net.repository")
public class ShadowNetSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShadowNetSpringApplication.class, args);
    }

//    public void run() {
//    }
}
