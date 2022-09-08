package practice.test0908;


public class Test01 {

	public static void main(String[] args) {
		long n=121;
		long answer=0;
		
		for(int i=1;i<=n;i++) {
			if(i*i==n) {
				answer=i;
				answer=(answer+1)*(answer+1);
				break;
			}else {
				answer=-1;
			}
		}
		System.out.println(answer);
	}

}
