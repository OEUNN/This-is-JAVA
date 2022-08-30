package practice0830;

import java.util.Scanner;

//시작수와 끝수를 입력 받고 주어진 배수의 합을 출력

//[입력]
//시작수: 1
//끝수: 15
//배수: 7

//[출력]
//21

public class codingtest01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시작수 :");
		int start=Integer.parseInt(sc.nextLine());
		System.out.print("끝수 :");
		int end=Integer.parseInt(sc.nextLine());
		
		int[] arr=new int[end];
		int j=0;
		
		for(int i=start;i<=end;i++) {
			arr[j]=i;
			j++;
		}
		
		System.out.print("배수 :");
		int num=Integer.parseInt(sc.nextLine());
		int sum=0;
		for(int i=0;i<=end-start;i++) {
			if(arr[i]%num==0) {
				sum+=arr[i];			
			}
		}
		System.out.println(sum);
	
	}

}
