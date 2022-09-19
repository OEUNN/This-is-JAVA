package ch12.sec06;

public class ValueCompareExample {

	public static void main(String[] args) {
		//범위 밖
		Integer obj1=300;
		Integer obj2=300;
		System.out.println("==: "+(obj1==obj2));
		System.out.println("equals(): "+obj1.equals(obj2));
		System.out.println();
		
		//범위 내
		Integer obj3=10;
		Integer obj4=10;
		System.out.println("==: "+(obj3==obj4));
		System.out.println("equals(): "+obj3.equals(obj4));
	}

}
