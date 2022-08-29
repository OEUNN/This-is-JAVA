package practice;

import java.util.Scanner;


public class codingtest03 {
	public static void main(String[] args) {
		
		int[] arr=new int[3];
		Scanner sc = new Scanner(System.in);
		String input=sc.nextLine();
		String[] cut= input.split(",");
		int sum=1;
		
		
		for(int i=0;i<3;i++) {
			arr[i]=Integer.parseInt(cut[i]);
			sum*=arr[i];
		}
		
		String n=String.valueOf(sum);
		int[] arr3= new int[n.length()];
		int[] arr4= new int[10];
		
		for(int i=0;i<n.length();i++) {
			arr3[i]=sum%10;
			sum/=10;
			if(sum<0) {
				break;
			}
			else {
				int tt=arr3[i];
				switch(tt) {
				case 0: arr4[0]+=1; break;
				case 1: arr4[1]+=1; break;
				case 2: arr4[2]+=1;	break;
				case 3: arr4[3]+=1; break;
				case 4: arr4[4]+=1; break;
				case 5: arr4[5]+=1; break;
				case 6: arr4[6]+=1; break;
				case 7: arr4[7]+=1; break;
				case 8: arr4[8]+=1; break;
				case 9: arr4[9]+=1; break;
				}		
			}
		}
		for(int i=0;i<10;i++) {
			System.out.println(arr4[i]);
		}
	}
}

