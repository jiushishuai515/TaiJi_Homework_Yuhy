package com.yuhongyue.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class TestUser {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_new");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();
//		 addUser(entityManager);
		 addAuthority(entityManager);
//		delUser(entityManager);
//		delAuthority(entityManager);

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

	
	public static void delAuthority(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Authority a = entityManager.find(Authority.class, 1);
		System.out.println(a.getUserList());
		entityManager.remove(a);

		// 5. 提交事务
		transaction.commit();

	}
	
	public static void delUser(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		User u = entityManager.find(User.class, 1);
		entityManager.remove(u);

		// 5. 提交事务
		transaction.commit();

	}

	public static void addAuthority(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// 4. 持久化操作
		Authority a = new Authority();

		a.setName("aaa");

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(a);

		// 5. 提交事务
		transaction.commit();

	}

	public static void addUser(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Authority> authorityList = entityManager.createQuery("SELECT a FROM Authority a ").getResultList();
		// 4. 持久化操作
		User u = new User();
		u.setPassword("123456");
		u.setUsername("王五");
		u.setAuthorityList(authorityList);
		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(u);

		// 5. 提交事务
		transaction.commit();

	}

}
