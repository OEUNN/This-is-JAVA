package ch08.sec11.exam01;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar =new Car();
		
		myCar.run();
		//타이어 객체 교체
		//필드가 인터페이스 타입이면 인터페이스로 구현한 객체만 모두 올 수 있다.
		myCar.tire1=new KumhoTire();
		myCar.tire2=new KumhoTire();
		
		myCar.run();
	}

}
