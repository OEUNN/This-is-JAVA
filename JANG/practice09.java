package ch05.practice;

import java.util.Scanner;

//학생들의 점수를 분석하는 프로그램을 만들려고 합니다. 
//키보드로부터 학생 수와 각 학생들의 점수를 입력받고 while문과 Scanner의 nextlie() 메소드를 이용
//최고점수 및 평균 점수 출력


public class practice09 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);//scanner 타입의 변수 input에 입력을 받는다.
		int[] students=null;
		int studentsNum=0;
		boolean o=true;
		
		
		while(o) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>");
			int num=Integer.parseInt(input.nextLine());
			
			if(num==1) {
				System.out.print("학생수> " );
				studentsNum=Integer.parseInt(input.nextLine());
				students=new int[studentsNum];
			}
			
			else if(num==2) {
				for(int i=0;i<studentsNum;i++) {
						System.out.print("score["+i+"] > ");
						students[i]=Integer.parseInt(input.nextLine());
				}
			}
			
			else if(num==3) {
				for(int i=0;i<studentsNum;i++) {
						System.out.println("score["+i+"] > " +students[i]);
				}
			}
			
			else if(num==4) {
				int max=0, sum=0;
				for(int i=0;i<studentsNum;i++) {
						if(max<students[i]) {
							max=students[i];
						}
						sum+=students[i];
					}
				System.out.println("최고 점수: "+max);
				System.out.println("평균 점수: "+(double)sum/studentsNum);
			}
			
			else if(num==5) {
				System.out.println("프로그램 종료");
				break;
			}
		
		}
		

	}

}


