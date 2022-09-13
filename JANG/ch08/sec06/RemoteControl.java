package ch08.sec06;

public interface RemoteControl {
	int MAX_VOLUME=10;
	int MIN_VOLUME=0;
	
	//기능은 3가지 
	void turnOn();
	void turnOff();
	void setVolume(int volume); 
	int getVolume();
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");//true
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음 해체합니다.");
		}
	}
	
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
}
