package ch16.sec05.exam03;

public class ConstructorReferenceExample {

	public static void main(String[] args) {
		Person person=new Person();
		
		Member m1=person.getMember1((id)->{
			Member m=new Member(id);
			return m;
		});
		//id를 닫아서 id를 매개값으로 주었다. 생성자를 매개값으로 id를 주었다.
		m1=person.getMember1((id)->new Member(id));
		//생성자 참조로 변환
		m1=person.getMember1(Member::new);
		//toString이 자동으로 호출된다.
		System.out.println(m1+"\n");
		
		
		Member m2=person.getMember2((id,name)->{
			Member m=new Member(id,name);
			return m;
		});
		m2=person.getMember2((id,name)->new Member(id,name));
		//생성자 참조
		m2=person.getMember2(Member::new);
		System.out.println(m2);
	}

}
