package ch11.sec04;

public class TryWithResourceExample {

	public static void main(String[] args) throws Exception {
		MyResource res1=null;
		
		try {
			//resource open
			res1=new MyResource("res1"); 
			//resource read
			System.out.println(Integer.parseInt(res1.read1()));
			System.out.println(Integer.parseInt(res1.read2()));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//resource close
			res1.close();
		}
		
		
		try (MyResource res2=new MyResource("res2")){
			//resource read
			System.out.println(Integer.parseInt(res2.read1()));
			System.out.println(Integer.parseInt(res2.read2()));	
		}catch(Exception e) {
			e.printStackTrace();
		}//닫는 코드는 없지만 닫기가 출력이 된다.
		
		
		MyResource res3=new MyResource("res3");
		try (res3){
			//resource read
			System.out.println(Integer.parseInt(res3.read1()));
			System.out.println(Integer.parseInt(res3.read2()));	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//자동 resource 닫기(resource가 AutoClosealbe을 구현하고 있어야한다.)
		MyResource res4=new MyResource("res4");
		MyResource res5=new MyResource("res5");
		try (res4; res5){
			//resource read
			System.out.println(Integer.parseInt(res4.read1()));
			System.out.println(Integer.parseInt(res4.read2()));	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
