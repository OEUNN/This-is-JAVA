package ch16.sec05.exam01;

public class LambdaExample {

	public static void main(String[] args) {
		Person person=new Person();
		
		//정적메소드 참조
		//람다식
		person.action((x,y)->{
			return Computer.staticMethod(x, y);
		});
		person.action((x,y)-> Computer.staticMethod(x, y));
		//메소드 참조
		person.action(Computer::staticMethod);
		
		
		//인스턴스메소드 참조
		Computer com=new Computer();
		//람다식
		person.action((x,y)->{
			return com.instanceMethod(x,y);
		});
		person.action((x,y)->com.instanceMethod(x, y));
		//메소드 참조
		person.action(com::instanceMethod);
		
	}
}
