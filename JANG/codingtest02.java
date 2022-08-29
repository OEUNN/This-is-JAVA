package practice;
//7개의 자연수가 주어질때, 이들 중 홀수인 자연수들을 모두 골라 그 합을 출력하고, 고른 홀수들 중 최솟값을 출력하는 프로그램을 작성하시오.
//만약 홀수가 존재하지 않는 경우에는 첫째 줄에 -1츨 출력한다.

import java.util.Scanner;

public class codingtest02 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String input= sc.nextLine();
		String[] cut=input.split(",");
		int[] arr = new int [7];
		int sum=0; 
		int min=0;
		
		for(int i=0;i<7;i++) {
			arr[i]= Integer.parseInt(cut[i]);// ","로 입력값을 자를수 있다.
		}
		
		for(int i=0;i<7;i++) {
			if((arr[i]%2)==0) {
				arr[i]=0;
			}
			sum+=arr[i];
		}	
		
		if(sum==0) {
			System.out.println("-1");
		}
		else {
			sum=0;
			for(int i=0;i<7;i++) {
				if((arr[i]%2)!=0) {
					sum+=arr[i];
					if(min>arr[i]) {
						min=arr[i];
					}else if(min==0) {
						min=arr[i];
					}
				}
			}
			System.out.println("최종값은\n"+sum);
			System.out.println("홀수중 최솟값\n"+min);
		}
		
		
	}

}
