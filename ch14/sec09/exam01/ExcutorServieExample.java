package ch14.sec09.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExcutorServieExample {

	public static void main(String[] args) {
//		ExecutorService excutorService = Executors.newCachedThreadPool();
		ExecutorService excutorService = Executors.newFixedThreadPool(5);
		excutorService.shutdownNow();

	}

}
