package practice.test0907;
//행렬의 덧셈

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1= {{1,2},{2,3}};
		int[][] arr2= {{3,4},{5,6}};
		int[][] answer= {};
		
		for(int i=0;i<arr1.length;i++) {
			//arr1의 0자리의 길이가 2차원수 배열의 길이 이므로 자리를 지정해서
			for(int j=0;j<arr1[0].length;j++) {  
				answer[i][j]=arr1[i][j]+arr2[i][j];
				System.out.println(answer[i][j]);
			}
		}
		
		
	}

}
