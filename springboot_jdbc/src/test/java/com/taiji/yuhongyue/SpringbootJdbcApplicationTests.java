package com.taiji.yuhongyue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJdbcApplicationTests {

	//线程安全
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource data;
	
	
	
	public void setDataSource(DataSource dataSource) {
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	
//	//具名参数
//	public void countOfActorsByFirstName(String firstName) {
//
//	    String sql = "select count(*) from T_ACTOR where first_name = :first_name";
//
//	    SqlParameterSource namedParameters = new MapSqlParameterSource("first_name", firstName); // this
//
//	    System.out.println(this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class));
//	}
//	 //  具名参数 测试
//	@Test  
//	public void namedtemplate() {
//		
//		countOfActorsByFirstName("laowang");	
//	}
//	
	
	//simpleJdbcInsert    线程不安全
	@Test
	public void simpleInsert() {
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(data).withTableName("t_actor");
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		parameters.put("id", "4");
        parameters.put("first_name", "六六六");
        parameters.put("last_name", "贼溜");
		int flag = simpleJdbcInsert.execute(parameters);
		System.out.println(flag);
	}
		
	//template的使用  线程安全
//	@Test
//	public void contextLoads() {
//
//		int rowCount = this.jdbc.queryForObject("select count(*) from stu", Integer.class);
//		System.out.println(rowCount);
//
//		// System.out.println("输入sid");
//		// Scanner scanner = new Scanner(System.in);
//		// 2);
//
//		// System.out.println("输入name");
//		// Scanner scanner1 = new Scanner(System.in);
//		// String name=scanner1.nextLine();
//		//
//		// int flag =this.jdbc.update("insert into stu (name) values(?)",name);
//		// System.out.println("有"+flag+"行受影响");
//		// List list =this.jdbc.queryForList("select * from stu");
//		// System.out.println(list);
//
//		RowMapper<Actor> rowMapper = new RowMapper<Actor>() {
//			public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Actor actor = new Actor();
//				actor.setFirstName(rs.getString("first_name"));
//				actor.setLastName(rs.getString("last_name"));
//				return actor;
//			}
//		};
//
//		// 单一
//		Actor actor = this.jdbc.queryForObject("select first_name, last_name from t_actor where id = ?",
//				new Object[] { 1 }, rowMapper);
//
//		System.out.println(actor.toString());
//
//		// 多个
//		List<Actor> actors = this.jdbc.query("select first_name, last_name from t_actor", rowMapper);
//		System.out.println(actors);
//		
//		
//	
//	}

}
