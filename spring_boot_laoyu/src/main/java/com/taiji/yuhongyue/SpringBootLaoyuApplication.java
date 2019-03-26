package com.taiji.yuhongyue;


import java.util.stream.Collectors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
public class SpringBootLaoyuApplication {

	public static void main(String[] args) {
		System.out.println("开始运行");
		SpringApplication.run(SpringBootLaoyuApplication.class, args);
		System.out.println("结束运行");
	}

//	@Bean
//	public ApplicationRunner appRunner() {
//		return args -> {
//			System.out.println();
//			System.out.println("applicationRunner");
//			for (String opt : args.getOptionNames()) {
//				System.out.print(opt);
//				System.out.print("->");
//				System.out.println(args.getOptionValues(opt).stream().collect(Collectors.toList()));
//			}
//		};
//	}
//
//	@Bean
//	public ApplicationListener<ApplicationEvent> helloListener() {
//		final String HELLO_URL = "/hello";
//		return (ApplicationEvent event) -> {
//			if (event instanceof ServletRequestHandledEvent) {
//				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
//				if (e.getRequestUrl().equals(HELLO_URL)) {
//					System.out.println("visit hello!!!");
//				}
//			}
//		};
//	}

}
