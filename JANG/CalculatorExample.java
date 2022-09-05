package ch06.sec08.exan01;

import java.util.Scanner;

public class CalculatorExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//Calculator 객체 생성
		Calculator myCalc=new Calculator();
		
		//리턴값이 없는 powerOn{} 메소드 호출
		myCalc.powerOn();
		
		//리턴값이 없는 powerOff() 메소드 호출
		myCalc.powerOff();
		
		//plus 메소드 호출 시 5와 6을 매개값으로 제공하고,
		//덧셈 결과를 리턴 받아 result1 변수에 대입
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : "+result1);
		
		
		//divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고,
		//나눗셈 결과를 리턴 바아 result2 변수에 대입
		double result2=myCalc.divide(10,4);
		System.out.println("result2 : "+result2);
		
		
		//제곱근의 결과를 리턴
		long result3=myCalc.power(2,3);
		System.out.println("result3 : "+result3);
		
		int c=10;
		//팩도리얼(1*2*3*4*...*10)
		long result4=myCalc.facotrial(c);
		System.out.println("result4 : "+result4);
		
		
		double d=Double.parseDouble(sc.nextLine());
		double e=Double.parseDouble(sc.nextLine());
		myCalc.remainder(d,e);
		
		int start=Integer.parseInt(sc.nextLine());
		int n=Integer.parseInt(sc.nextLine());
		int result6=myCalc.randomNum(start,n);
		System.out.println("result6 : "+result6);
		
		
		

		
		

	}

}
