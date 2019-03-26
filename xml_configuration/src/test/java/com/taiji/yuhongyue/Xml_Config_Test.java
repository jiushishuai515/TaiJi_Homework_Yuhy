package com.taiji.yuhongyue;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.taiji.yuhongyue.bean.BeanOne;
import com.taiji.yuhongyue.bean.BeanTwo;


public class Xml_Config_Test {

private AbstractApplicationContext context;
	
	public Xml_Config_Test() {
		
		context = new FileSystemXmlApplicationContext("classpath:/META-INF/application-context.xml");
//		context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
		context.registerShutdownHook();		
	}

	
	@Test
	public void test() {
		BeanOne beanOne = context.getBean("beanOne",BeanOne.class);
		BeanTwo beanTwo = context.getBean("beanTwo",BeanTwo.class);
		System.out.println(beanOne.getMsg());
		System.out.println(beanTwo.getMsg());
		System.out.println(beanOne.getName());

	}

	
}
