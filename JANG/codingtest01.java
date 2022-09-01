package practice0831;
//태희code
//((#(())#(())))

import java.util.Scanner;

public class codingtest01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] mount=sc.nextLine().split("");
		
		int high=0;
		int sum=0;
		int slope=1;
		boolean choice=true;
		
		for(int i=0;i<mount.length;i++) {
			if(mount[i].equals("(")) {
				high++;
				sum+=high*slope;
			}else if(mount[i].equals(")")){
				sum+=high*slope;
				high--;
			}else if(mount[i].equals("#")){
				if(choice==false) {
					slope=2;
					choice=true;
				}else
					slope=1;
					choice=false;
			}
		}
		 System.out.println(sum);
	}

}
