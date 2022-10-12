package ch20.oracle.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

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
			//트랜잭션 시작------------------------------
			//자동커밋기능 끄기
			conn.setAutoCommit(false);
			
			//출금작업
			String sql1="update accounts set balance=balance-? where ano=?";
			PreparedStatement pstmt1=conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int rows1=pstmt1.executeUpdate();
			if(rows1==0) throw new Exception("출금되지 않았음");
			pstmt1.close();
			
			//입금작업
			String sql2="update accounts set balance=balance+? where ano=?";
			PreparedStatement pstmt2=conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			int rows2=pstmt2.executeUpdate();
			if(rows2==0) throw new Exception("입금되지 않았음");
			pstmt2.close();
			
			conn.commit();
			System.out.println("계좌 이체 성공");
			
			
		} catch (Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				System.out.println("계좌이체 실패");
				e.printStackTrace();
			}
		}finally {
			if(conn!=null) {
				try {
					conn.setAutoCommit(true);
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
