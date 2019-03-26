package com.taiji.yuhongyue.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("beanBoth")
public class BeanBoth {
	
	@Autowired
	private BeanOne beanOne;
	
	@Autowired
	private BeanTwo beanTwo;

	public BeanBoth() {
		
	}

	@Autowired
	public BeanBoth(BeanOne beanOne, BeanTwo beanTwo) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
	}

	public BeanOne getBeanOne() {
		return beanOne;
	}

	public void setBeanOne(BeanOne beanOne) {
		this.beanOne = beanOne;
	}

	public BeanTwo getBeanTwo() {
		return beanTwo;
	}

	public void setBeanTwo(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	
	
	

}
