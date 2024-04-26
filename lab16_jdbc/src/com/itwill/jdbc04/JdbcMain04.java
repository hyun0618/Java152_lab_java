package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;
import static com.itwill.jdbc.model.Blog.Entity.*;

public class JdbcMain04 {

	public static void main(String[] args) throws SQLException {
		// delete 문장 실행 & 결과 처리
		
		Scanner sc = new Scanner(System.in);
		
		// 오라클 드라이버 등록 
		DriverManager.registerDriver(new OracleDriver());
		
		// 오라클 DB에 접속
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		//
//		final String sql = "delete from blogs where id = ?";
		final String sql = String.format("delete from %s where %s = ?", TBL_BLOGS, col_id);
		PreparedStatement stmt = conn.prepareStatement(sql);
	
		//
		stmt.setInt(1, 3);
			
		//
		int result = stmt.executeUpdate();
		System.out.println(result + "개 행이 삭제 됨.");
		
		//
		stmt.close();
		conn.close();
		
	}

}
