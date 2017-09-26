package com.example.wangwq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.wangwq.method.Operating.add;

/**
 * @author wangwq
 * @date 2017.9.25 16:03
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
