package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch20.oracle.sec09.exam02.Board;

public class UserSelectExample {

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
			String sql="select bno,btitle,bcontent,bwriter, bdate, bfilename, bfiledata from boards where bwriter=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				//행의 수만큼 반복한다.
				Board board=new Board();
			}
			rs.close();

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
	
	public static void printUser(String userId, String userName, String userPassword, int userAge, String userEmail) {
		System.out.println("userId: "+userId);
		System.out.println("userName: "+userName);
		System.out.println("userPassword: "+userPassword);
		System.out.println("userAge: "+userAge);
		System.out.println("userEmail: "+userEmail);
	}
	

	public static void printUser(User user) {
		/*
		System.out.println("userId: "+user.getUserId());
		System.out.println("userName: "+user.getUserName());
		System.out.println("userPassword: "+user.getUserPassword());
		System.out.println("userAge: "+user.getUserAge());
		System.out.println("userEmail: "+user.getUserEmail());
		*/
		//toString 메소드 호출
		System.out.println(user);
	}


}
