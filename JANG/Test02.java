package practice.test0919;

public class Test02 {

	public static void main(String[] args) {
		int[] arr= {54,7,5,9};
		boolean result =false;
		int cnt=0;
		int min=0;
		
		if(arr.length<2) {
			result = false;
			cnt=1;
		}else {
			result = true;
			cnt=arr.length-1;
		}
		
		int[] answer=new int[cnt];	
		cnt=0;
		if(result) {
			for(int i=0;i<arr.length;i++) {
				if(min>arr[i]) {
					min=arr[i];
					cnt=i;
				}else if(min==0) {
					min=arr[i];
				}
			}
			arr[cnt]=0;
			cnt=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]!=0) {
					answer[cnt]=arr[i];
					cnt++;
				}
			}
		}else
			answer[0]=-1;
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}

}
