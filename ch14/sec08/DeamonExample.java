package ch14.sec08;

public class DeamonExample {

	public static void main(String[] args) {
		AutosaveThread thread=new AutosaveThread();
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {}
		
		thread.interrupt();
		System.out.println("main스레드 종료");
	}

}
