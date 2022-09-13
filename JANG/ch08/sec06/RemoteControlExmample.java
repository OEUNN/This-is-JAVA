package ch08.sec06;

public class RemoteControlExmample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		
		rc=new Televison();
		rc.turnOn();
		rc.setVolume(12);
		
		rc.setMute(true);
		rc.setMute(false);
		System.out.println("현재 volume : "+rc.getVolume());
		System.out.println();
		
		rc=new Audio();
		rc.turnOn();
		rc.setVolume(5);
		
		rc.setMute(true);
		rc.setMute(false);
		
		System.out.println("현재 volume : "+rc.getVolume());
		
	}

}
