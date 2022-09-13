package ch08.sec08;

public class MultiInterfaceImplExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc=new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		Serchable searchable = new SmartTelevision();
		
		searchable.search("https://www.youtube.com");
	}

}
