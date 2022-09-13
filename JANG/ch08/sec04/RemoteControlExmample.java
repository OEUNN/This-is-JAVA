package ch08.sec04;

public class RemoteControlExmample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		
		rc=new Televison();
		rc.turnOn();
		rc.setVolume(12);
		rc.turnOff();
		
		rc=new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
	}

}
