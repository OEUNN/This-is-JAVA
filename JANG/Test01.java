package practice0906.exam01;

public class Test01 {
	public static void main(String[] args) {
		int[] absolutes= {4,7,12};
		boolean[] signs= {true, false, true};
		int sum=0;
		for(int i=0;i<absolutes.length;i++) {
			if(signs[i]==false) {
				absolutes[i]*=-1;
			}
			sum+=absolutes[i];
		}
		System.out.println(sum);
	}
}
