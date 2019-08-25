package com.crazyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.crazyang.mapper")
public class Java2019Application {

	public static void main(String[] args) {
		SpringApplication.run(Java2019Application.class, args);
	}

}
