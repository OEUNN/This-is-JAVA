package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		
		set.add("JAVA");
		set.add("JDBC");
		set.add("JSP");
		set.add("Spring");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element=iterator.next();
			System.out.println(element);
			if(element.equals("JSP")) {
				iterator.remove();
			}
		}
		
		System.out.println();
		
		set.remove("JDBC");
		
		for(String element : set)
			System.out.println(element);
		
		
		/*
		//for문 안에서 remove와 add를 사용하면 안된다. 
		//for문은 처음 시작할때 몇번을 돌지 생각하고 하기때문에 set의 길이 변경을하면 안된다.
		for(String element : set) {
			if(element.equals("JDBC")) {
				set.remove(element);
			}
			System.out.println(element);
		}*/
		
	}

}
