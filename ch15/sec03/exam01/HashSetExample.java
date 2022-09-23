package ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("JAVA");
		set.add("JDBC");
		set.add("SOD");
		set.add("JAVA");
		set.add("SDFSD");
		
		int size=set.size();
		System.out.println("총 객체 수: "+size);

	}

}
