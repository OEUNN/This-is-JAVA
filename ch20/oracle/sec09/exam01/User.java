package ch20.oracle.sec09.exam01;

import lombok.Data;

//DB에 있는 데이터를 이용해 매핑을 해서 필드를 정의한다.
//자동으로 getter와 setter가 생성된다.
@Data
public class User {
	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
}
