package ch16.sec05.exam02;

public class MethodReferenceExample {

	public static void main(String[] args) {
		Person person =new Person();
		
		person.ordering((a,b)->{
			return a.compareToIgnoreCase(b);
			//a<b 음수
			//b.compareToIgnoreCase(a)이면 -> a<b이면 양수
		});
		person.ordering((a,b)->a.compareToIgnoreCase(b));
		person.ordering(String::compareToIgnoreCase);
	}

}
