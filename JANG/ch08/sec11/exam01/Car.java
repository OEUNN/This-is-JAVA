package ch08.sec11.exam01;

public class Car {
	//인터페이스 타입으로 선언해 놓으면 인터페이스로 구현해놓은 타입은 모두 올 수 있다.
	Tire tire1=new HankookTire();
	Tire tire2=new HankookTire();
	
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
