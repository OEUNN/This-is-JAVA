package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		String data1 = "홍길동&이수홍,박연수";
		String[] arr=data1.split("&|,");
		for(String token : arr) {
			System.out.println(token);
		}
		System.out.println();
		
		String data2= "홍길동/이수홍/박연수";
		StringTokenizer st=new StringTokenizer(data2,"/");
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		//nextToken()을 사용하기전에 haseMoreTokens()메소드를 통해 문자열이 있는지 확인부터 해야한다.

	}

}
