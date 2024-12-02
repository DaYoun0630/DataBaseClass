package com.project.funding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.funding.mapper") // Mapper 인터페이스 경로 지정
public class FundingMallApplication {
	public static void main(String[] args) {
		SpringApplication.run(FundingMallApplication.class, args);
	}
}
