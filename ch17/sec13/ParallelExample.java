package ch17.sec13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelExample {

	public static void main(String[] args) {
		Random random=new Random();
		
		List<Integer> scores = new ArrayList<>();
		for(int i=0;i<100000000;i++) {
			scores.add(random.nextInt(101));
		}
		
		double avg=0.0;
		long startTime=0;
		long endTime=0;
		long time=0;
		
		//일반 stream 처리
		Stream<Integer> stream=scores.stream();
		startTime=System.nanoTime();
		avg=stream
				.mapToInt(i->i.intValue())
				.average()
				.getAsDouble();
		endTime=System.nanoTime();
		time=endTime-startTime;
		System.out.println("basicStream\tavg: "+avg+"time: "+time);
		
		//병렬 stream 처리
		Stream<Integer> parallelStream=scores.parallelStream();
		startTime=System.nanoTime();
		avg=parallelStream
				.mapToInt(i->i.intValue())
				.average()
				.getAsDouble();
		endTime=System.nanoTime();
		time=endTime-startTime;
		System.out.println("parallelStrem\tavg: "+avg+"time: "+time);

	}

}
