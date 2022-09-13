package ch08.sec02;

public class RemotControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		rc=new Television();
		rc.turnOn();
		//교체
		rc=new Audio();
		rc.turnOn();

	}

}
