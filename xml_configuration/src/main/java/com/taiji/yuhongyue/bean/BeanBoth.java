package com.taiji.yuhongyue.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanBoth {

	private BeanOne beanOne;

	private BeanTwo beanTwo;

	private int a;

	public BeanBoth() {

	}

	@Autowired
	public BeanBoth(BeanOne beanOne, BeanTwo beanTwo,int a) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
		this.a=a;
	}

	public BeanOne getBeanOne() {
		return beanOne;
	}

	public void setBeanOne(BeanOne beanOne) {
		this.beanOne = beanOne;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public BeanTwo getBeanTwo() {
		return beanTwo;
	}

	public void setBeanTwo(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}

}
