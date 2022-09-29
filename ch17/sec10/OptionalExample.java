package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

	public static void main(String[] args) {
		List <Integer> list = new ArrayList<>();
		
		/*
		//예외발생(java.util.NoSuchElementException)
		double avg=list.stream()
				.mapToInt(Integer::intValue)
				.average()
				.getAsDouble();
		*/
		
		OptionalDouble optional=list.stream()
				.mapToInt(Integer::intValue)
				.average();
		if(optional.isPresent()) {
			System.out.println("avg : "+optional.getAsDouble());
		}else
			System.out.println("avg : 0.0");
		
		double avg=list.stream()
				.mapToInt(Integer::intValue)
				.average()
				.orElse(0.0);
		System.out.println("avg2: "+avg);
		
		list.stream()
			.mapToInt(Integer::intValue)
			.average()
			.ifPresent(a->System.out.println("avg3: "+a));

	}

}
