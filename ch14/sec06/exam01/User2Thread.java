package ch14.sec06.exam01;

public class User2Thread extends Thread {
	private Calculator calculator;
	
	public User2Thread() {
		setName("user1Thread");//thread이름 바꾸기
	}
	public void setCalculator(Calculator calculator) {
		this.calculator=calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory2(50);
	}
}
