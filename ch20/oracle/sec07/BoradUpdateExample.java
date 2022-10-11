package ch20.oracle.sec07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoradUpdateExample {

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
			String sql=new StringBuilder()
					.append("UPDATE boards SET ")
					.append("btitle=?, ")
					.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ")
					.append("WHERE bno=?")
					.toString();
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno","btitle"});
			
			pstmt.setString(1, "해가 쨍쨍한날");
			pstmt.setString(2, "더워 죽겠어요");
			pstmt.setString(3, "photo2.jpg");
			pstmt.setBlob(4, new FileInputStream("src/ch20/oracle/sec07/photo2.jpg"));
			pstmt.setInt(5, 8);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행수: "+rows);
			
			pstmt.close();
			
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
