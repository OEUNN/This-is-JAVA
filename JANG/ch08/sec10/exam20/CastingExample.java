package ch08.sec10.exam20;

public class CastingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle=new Bus();
		
		vehicle.run();
		
		Bus bus=(Bus)vehicle;//강제타입변환
		bus.run();
		bus.checkFare();
	}

}
