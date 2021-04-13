package com.example.aosp_end;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.aosp_end.dao")
@SpringBootApplication
public class AospEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(AospEndApplication.class, args);
	}

}
