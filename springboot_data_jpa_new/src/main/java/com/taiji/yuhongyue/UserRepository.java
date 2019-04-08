package com.taiji.yuhongyue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>,PagingAndSortingRepository<User,String> {

	@Query("select u from User u ")
	List<User> findAllUsers();

	List<User> findByFlagOrderByIdDesc(@Param("flag") int i);
}
