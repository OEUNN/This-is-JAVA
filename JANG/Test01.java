package practice.test0920;

public class Test01 {

	public static void main(String[] args) {
		int n=3;
		String answer="";
		for(int i=0;i<n;i++) {
			if(i%2==0)
				answer+="수";
			else
				answer+="박";	
		}
		System.out.println(answer);
	}

}
