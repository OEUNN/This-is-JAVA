package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
	public static void printLength(String data) {
		try{
			int result=data.length();
			System.out.println("문자수:"+result);
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
//			System.out.println(e.toString());//예외의 종류와 사유
//			e.printStackTrace();
		}finally {
			System.out.println("마무리 실행");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램시작\n");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("end");
	}

}
