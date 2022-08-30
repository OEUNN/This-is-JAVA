package practice0830;

import java.util.Scanner;

public class codingtest02 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		char[] password=new char[word.length()];//배열을 char로 받는 것이 중요하다.
		
		for(int i=0;i<password.length;i++) {
			password[i]=word.charAt(i);//메소드 charAt()를 사용해서 char형으로 배열에 저장
			if(password[i]>'v') {
				password[i]-=22;
			}
		}
		
		for(int i=0;i<password.length;i++) {
			System.out.print(password[i]);
		}
		
	}
}

		