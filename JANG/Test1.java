package practice0905;

public class Test1 {

	public static void main(String[] args) {
		int[] numbers= {5,8,0,4,6,7,9};
		int[] arr= {0,1,2,3,4,5,6,7,8,9}; //초기 배열 설정
		int answer=0;
	
		//배열 비교를 위해 값 지워나가기
		for(int i=0;i<arr.length;i++) { 
			for(int j=0;j<numbers.length;j++) {
				if(arr[i]==numbers[j]) {
					arr[i]=0;
				}
			}
			answer+=arr[i];
		}
		System.out.println(answer);
		
	}

}
