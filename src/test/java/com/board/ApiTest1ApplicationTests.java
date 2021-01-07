package com.board;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.board.domain.BoardVO;
import com.board.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ApiTest1Application.class)
@WebAppConfiguration
public class ApiTest1ApplicationTests {

	// DataSource 객체 DI
//	@Autowired
//	private DataSource ds; 

	// sqlSession 객체 DI
	@Autowired
	private SqlSessionFactory sqlSession; 
	
	// Mapper 객체 DI
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testConnection() throws Exception {
		
		// mysql Datasource 및 Connection 확
//		System.out.println("ds : "+ds);
//		Connection con = ds.getConnection();
//		System.out.println("con : "+con);
//		con.close();
		
		// SqlSession 연결 확인
//		System.out.println("sqlSession :"+sqlSession);
		
		//DB에 insert문 사용하여 데이터 입력
		BoardVO vo = new BoardVO();
		
		vo.setSubject("Why korean letter doesn't insert..");
		vo.setContent("I don't get why korean letter doesn't insert why!! How can I solve this problem damn Mysql!!....");
		vo.setWriter("Mr.K_sad");
		
		mapper.boardInsert(vo);
	}
}
