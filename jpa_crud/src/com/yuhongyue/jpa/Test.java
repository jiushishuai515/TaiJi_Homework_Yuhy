package com.yuhongyue.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Test {

	@PersistenceContext
	EntityManager em;
	

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_new");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// add(entityManager);
		search(entityManager, "tom");

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

	public static void add(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123456");

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(user);

		// 5. 提交事务
		transaction.commit();

	}

	public static void search(EntityManager entityManager, String name) {

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// List<User> list = entityManager.createQuery("SELECT u FROM User u WHERE
		// u.name LIKE ?1")
		List<User> list = entityManager.createQuery("SELECT u FROM User u WHERE u.name LIKE ?1").setParameter(1, name)
				.getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

	}

}
