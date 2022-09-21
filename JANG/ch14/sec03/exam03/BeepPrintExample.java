package ch14.sec03.exam03;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		Thread thread = new Thread() { 
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0;i<5;i++) {
					toolkit.beep();
					try { Thread.sleep(500);} catch(Exception e){}
				}
			}
		};
		
		/*		
		thread.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch(Exception e) {}
		}
		*/
		
		/*
		//Runnable 인터페이스 implement
		Runnable task=new Task();
		Thread thread2=new Thread(task);
		thread2.start();
		*/
		
		//자식객체
		Thread thread3=new PrintThread();
		thread3.start();

	}

}
