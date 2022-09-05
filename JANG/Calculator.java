package ch06.sec08.exan01;

public class Calculator {
	
	
	//리턴값이 없는 메소드 선언
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	//리턴값이 없는 메소드 선언
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	//호출 시 두 정수 값을 전달받고,
	//호출한 곳으로 결과값 int를 리턴하는 메소드 선언
	int plus(int x, int y) {
		int result=x+y;
		return result;//리턴값 지정
		
	}
	
	//호출 시 두 정수 값을 전달받고,
	//호출한 곳으로 결과값 double을 리턴하는 메소드 선언
	double divide(int x, int y) {
		double result=(double)x/(double)y;
		return result;
	}
	
	//두수 제공
	//제곱근
	//type = long
	long power(int x, int y) {
		long result=1;
		for(int i=1;i<=y;i++) {
			result=result*x;
		}
		return result;		
	}
	
	//팩도리얼
	//값이 커질수 있으니 type은 long
	long facotrial(int x) {
		long result=1;
		for(int i=1;i<=x;i++) {
			result=result*i;
		}
		return result;
	}
	
	//double
	//출력하라고했으니 꼭 리턴할 필요가 없다. -> void 타입 사용
	void remainder(double x,double y) {
		double result=x%y;
		System.out.println("rsult5 : "+result);
	}
	
	//랜덤
	int randomNum(int x, int y) {
		int result=(int)((Math.random()*y)+x);
		//double형이기 때문에 int형으로 값을 리터럴하고, 
		//y개중에 1개를 뽑고
		//범위는 x~y까지 이다
		return result;
	}

	
}
