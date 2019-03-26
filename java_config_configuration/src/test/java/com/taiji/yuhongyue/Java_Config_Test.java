package com.taiji.yuhongyue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.taiji.yuhongyue.bean.BeanBoth;
import com.taiji.yuhongyue.bean.Java_Config;

public class Java_Config_Test {

	private AnnotationConfigApplicationContext context;

	@Before
	public void IntialContext() {
		context = new AnnotationConfigApplicationContext(Java_Config.class);
		context.registerShutdownHook();
		System.out.println("beans的个数:" + context.getBeanDefinitionCount());
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name + "=========>>");
			Object bean = context.getBean(name);
			System.out.println(bean.getClass());
		}
	}

	@Test
	public void test() {
		System.out.println(context.getBean(BeanBoth.class).getBeanOne().getName());
		System.out.println(context.getBean(BeanBoth.class).getBeanTwo().getName());

	}

}
