package com.yuhongyue.mytest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MyTestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_new");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		searchUsers(entityManager);

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

	// 查
	public static void searchUsers(EntityManager entityManager) {

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		
		List<Person> persons = entityManager.createQuery("SELECT p FROM Person p").getResultList();

		System.out.println(persons.toString());

	}

}
