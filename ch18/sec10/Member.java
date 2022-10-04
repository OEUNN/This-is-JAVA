package ch18.sec10;

import java.io.Serializable;

public class Member implements Serializable{
	private static final long serialVersionUID=1;
	private String id;
	private String name;
	private int age;
	
	public Member(String id, String name) {
		this.id=id;
		this.name=name;
	}
	@Override
	public String toString() {
		return id+": "+name;
	}
}
