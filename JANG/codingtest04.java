package practice0830;

import java.util.Scanner;

public class codingtest04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());//사과의 개수
		String [][] arr=new String[N][3]; //하나의 줄에 2차원배열을 사용해 모두 저장한다.
		String count=sc.nextLine();
		String[] cut=count.split(" "); //split를 사용해 space일때 잘라서 저장한다.
		String three= sc.nextLine();
		String four=sc.nextLine();
		
		int sum=0;
		
		for(int i=0;i<N;i++) {
			
			arr[i][0]=cut[i];
			
			char three1= three.charAt(i);//char변수로 변환
			arr[i][1]=String.valueOf(three1);//변환된 char -> string으로 바꿔 저장
			
			char four1=four.charAt(i);
			arr[i][2]=String.valueOf(four1);
						
			if((arr[i][1].equals("O"))&&(arr[i][2].equals("O"))) {
				sum+=Integer.parseInt(arr[i][0]);
			}
			
		}
		System.out.println(sum);

	}

}
