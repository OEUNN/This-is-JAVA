package ch14.sec07.exam02;

public class PrintThread extends Thread {
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("~ing");
//				Thread.sleep(1);
				if(Thread.interrupted()) {
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("resource clean");
		System.out.println("end");
	}
}
