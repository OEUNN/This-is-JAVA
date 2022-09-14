package ch09.sec02.exam01;

public class AExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		A.B b=a.new B();
		b.methodB();
	}

}
