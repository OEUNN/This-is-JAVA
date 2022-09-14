package ch09.sec02.exam01;

public class A {
	//Field
	int field;
	B field2;
	//Constructor
	//Method
	//Nested Class 중첩된
	A(){
		B b=new B();
		b.methodB();
	}
	public class B{
		//Field
		//Constructor
		//Method
		public void methodB() {
			System.out.println("MethodB()실행");
		}
	}
}
