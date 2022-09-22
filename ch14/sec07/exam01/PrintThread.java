package ch14.sec07.exam01;

public class PrintThread extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop=stop;
	}
	@Override
	public void run() {
		while(!stop)
			System.out.println("~ing");
		System.out.println("resource clean");
		System.out.println("end");
	}
}
