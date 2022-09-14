package ch09.sec04.exam02;

public class A {
	
	void useB() {
		class B{
			int field1=1;
			static int fielde2=2;
			B(){
				System.out.println("B-생성자");
			}
			void method1() {
				System.out.println("B-method1");
			}
			static void method2() {
				System.out.println("B-method2");
			}
		}
		
		B b=new B();
		
		System.out.println(b.field1);
		b.method1();
		
		System.out.println(B.fielde2);
		B.method2();
	}
}
