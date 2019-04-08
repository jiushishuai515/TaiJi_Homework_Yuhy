package com.yuhongyue.mytest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MyTestSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_new");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 增删改查
		// addPerson(entityManager);
//		 addAddress(entityManager);
		// delPerson(entityManager);
		updateUser(entityManager);
		// searchPerson(entityManager);

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();

	}

	// 增地址
	private static void addAddress(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		Address address = new Address();
		address.setAddressName("荣达路");

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(address);

		// 5. 提交事务
		transaction.commit();

	}

	// 增用户
	public static void addPerson(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		Person person = new Person();
		person.setName("laoyu");
		person.setAge(26);

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(person);

		// 5. 提交事务
		transaction.commit();

	}

	// 删
	public static void delPerson(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Person person = entityManager.find(Person.class, 1);
		System.out.println(person.getAddressList());
		entityManager.remove(person);

		// 5. 提交事务
		transaction.commit();

	}

	// 改
	public static void updateUser(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Person person = entityManager.find(Person.class,2);
		System.out.println(person.toString());
		// 4. 持久化操作
		person.setId(2);
		person.setName("laowang");
		person.setAge(100);
		
		
		// 添加user到数据库，相当于hibernate的save();
		entityManager.merge(person);
		// 5. 提交事务
		transaction.commit();

	}

	// 查
	public static void searchPerson(EntityManager entityManager) {

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Object person = entityManager.createQuery("SELECT p FROM Person p WHERE p.name = 'laoyu'").getSingleResult();

		System.out.println(person.toString());

	}

}
