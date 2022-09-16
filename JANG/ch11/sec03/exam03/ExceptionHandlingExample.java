package ch11.sec03.exam03;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		String[] array= {"100","1oo",null,"200"};
		
		for(int i=0;i<=array.length;i++) {
			try {
				System.out.println(array[i].length());
				int value=Integer.parseInt(array[i]);
			}catch(NumberFormatException e) {
				System.out.println("index:"+e.getMessage());
			}catch(Exception e) {
				System.out.println("not number"+e.getMessage());
			}
		}

	}

}
