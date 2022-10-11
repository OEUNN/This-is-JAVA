package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {

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
			String sql="insert into boards(bno,btitle,bcontent,bwriter,bdate,bfilename,bfiledata) values(seq_bno.nextval,?,?,?,SYSDATE,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno","btitle"});
			
			pstmt.setString(1, "겨우울");
			pstmt.setString(2, "춥다.");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "photo1.jpg");
			pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec06/photo1.jpg"));
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행수: "+rows);
			
			if(rows==1) {
				ResultSet rs = pstmt.getGeneratedKeys();//생성되어진 키를 갖고와,bno룰 자여올 것이다.
				if(rs.next()) {
					int bno=rs.getInt(1);
					System.out.println("저장된 bno: "+bno);
					
					String btitle=rs.getString(2);
					System.out.println("저장된 btitle: "+btitle);
				}
				rs.close();
			}
			
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
