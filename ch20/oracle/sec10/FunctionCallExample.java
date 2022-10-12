package ch20.oracle.sec10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionCallExample {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/orcl",
					"java",
					"oracle"
					);
			System.out.println("연결성공");
			
			//DB작업
			String sql="{?=call user_login(?,?)}";
			CallableStatement cstmt=conn.prepareCall(sql);
			
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, "winter");
			cstmt.setString(3, "12345");
			
			//함수 실행 및 리턴값 얻기
			cstmt.execute();
			int result=cstmt.getInt(1);
			//CallableStatement 닫기
			cstmt.close();
			
			String message = switch(result) {
				case 0->"로그인 성공";
				case 1 -> "비밀번호가 틀림";
				default-> "아이디가 존재하지 않음";
			};
			System.out.println(message);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					//DB 연결 끊기
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
