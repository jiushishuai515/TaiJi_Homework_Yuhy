package com.taiji.yuhongyue.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Java_Config {

	@Bean
	public BeanBoth beanBoth() {
		BeanBoth beanBoth = new BeanBoth();
		beanBoth.setBeanOne(beanOne());
		beanBoth.setBeanTwo(beanTwo());
		return beanBoth;
	}

	@Bean
	@Primary
	public BeanOne beanOne() {
		BeanOne beanOne = new BeanOne();
		beanOne.setName("im beanOne");
		return beanOne;
	}

	@Bean
	public BeanTwo beanTwo() {
		BeanTwo beanTwo = new BeanTwo();
		beanTwo.setName("im beanTwo");
		return beanTwo;
	}

}
