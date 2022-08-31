package practice0830;

import java.util.Scanner;

public class codingtest05{

   public static void main(String[] args) {
      
      Scanner sc=new Scanner(System.in);
      int N=Integer.parseInt(sc.nextLine());//암기가능수
      int W=Integer.parseInt(sc.nextLine());//선생님 불어준 단어
      String c=sc.nextLine();
      String[] cut=c.split(" ");
      String[] arr=new String[W];//선생님이 불러준 단어 배열
      String[] arr1=new String[N];
      int sum=0;
      int result=0;      
      int cnt=0;//걸린시간 카운트
      int plus=1;
      int len=0;

      //선생님이 불러주는 단어
      for(int i=0;i<W;i++) {
         arr[i]=cut[i];
      }
      
      //초기 배열 값
      for(int i=0;i<N;i++) {
         arr1[i]=arr[i];
         cnt+=3;
      }
      
      //hi hello bye hi what bye good smart creative create
      for(int i=0;i<arr.length-arr1.length;i++) {
         if(i<(arr.length-arr1.length-1)) {
            len=arr1.length+plus;  
         }
         
         sum=0;
         for(int j=0;j<arr1.length;j++) {
            sum+=arr1[j].length();//길이 더하기   
         }   
         result=sum/arr1.length;//길이평균
         
         for(int j=0;j<arr1.length;j++) {
            if(arr1[j].equals(arr[len])) {
               arr1[0]=null;//처음값에 쓰레기 입력
               for(int k=0;k<N;k++) {
                  if(k<N-1) {
                     arr1[k]=arr1[k+1];
                  }else{
                     arr1[N-1]=arr[len];
                  }
               }
               plus++;
               cnt++;
               break;
            }else {   
               for(int k=0;k<arr1.length;k++) {
                  if(arr1[k].length()>result) {
                     continue;
                  }else {
                     arr1[k]=arr[len];
                     break;
                     }
                  }
               plus++;
               cnt+=3;
               break;
               }
            }
         
      }
      System.out.println(cnt);
   }
}
   
   