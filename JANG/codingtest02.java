package practice0831;

import java.util.Scanner;

public class codingtest02 {

	public static void main(String[] args) {
		//숫자 문자열과 영단어
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		//s.length()는 1이상 50이하
		s=s.replace("zero","0");
		s=s.replace("one","1");
		s=s.replace("two","2");
		s=s.replace("three","3");
		s=s.replace("four","4");
		s=s.replace("five","5");
		s=s.replace("six","6");
		s=s.replace("seven","7");
		s=s.replace("eight","8");
		s=s.replace("nine","9");
		System.out.println(s);
	}

}
