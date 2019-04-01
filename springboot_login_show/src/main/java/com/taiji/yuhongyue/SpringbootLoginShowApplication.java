package com.taiji.yuhongyue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages="com.taiji.yuhongyue.dao") 
public class SpringbootLoginShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLoginShowApplication.class, args);
	}

}
