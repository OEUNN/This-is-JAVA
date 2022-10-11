package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {

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
			//insert문 실행을 위한 코드
			//매개변수화된 sql문, ?에는 데이터가 들어온다.
			String sql="insert into users(userid, username, userpassword, userage, useremail) values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "fall2");//컬럼의 데이터 타입을 보고 set의 타입 설정
			pstmt.setString(2, "sss");
			pstmt.setString(3, "1234");
			pstmt.setInt(4, 27);
			pstmt.setString(5, "fall@mycompany.com");
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행수: "+rows);
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
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
