package practice0906.exam01;

import java.util.Scanner;

public class BankApplication {
   static public Account[] accountArray=new Account[100];
   static Scanner sc=new Scanner(System.in);
   static int index=0;

   public static void main(String[] args) {
      boolean flag = true;
      while(flag) {
         System.out.println("-------------------------------");
         System.out.println("1.create 2.list 3.plus 4.minus 5.end");
         System.out.println("-------------------------------");
         System.out.print("선택>");
         int input=Integer.parseInt(sc.nextLine());
         
         switch(input) {
         case 1: create(); break;
         case 2: list(); break;
         case 3: addMoney(); break;
         case 4: minusMoney();
         case 5: System.out.println("end"); flag=false; break;
         }
         
      }

   }
   static void create() {
      System.out.println("**create**");
      Account account1=new Account();
      
      System.out.print("account number: ");
      account1.setNumber(sc.nextLine());
      
      System.out.print("account number: ");
      account1.setName(sc.nextLine());
      
      System.out.print("account number: ");
      account1.setBalance(Integer.parseInt(sc.nextLine()));
      
      accountArray[index]=account1;      
      index++;
      
      System.out.println("complete!");   
   }
   
   static void list() {
      System.out.println("**list**");
      
      for(Account ac:accountArray ) {
         if(ac==null)
            break;
         System.out.println(ac);
      }   
   }
   
   static void addMoney() {
      System.out.println("**Add_Money**");
      System.out.println("account number: ");
      String str=sc.nextLine();
      for(Account ac:accountArray) {
         if(ac.getNumber().equals(str)) {
            System.out.println("how much money add?");
            ac.addMoney(Integer.parseInt(sc.nextLine()));
            break;
         }else
            System.out.println("not found number");
      }
   }
   
   static void minusMoney() {
      System.out.println("**Minus_Money");
      System.out.print("account nuber: ");
      String str=sc.nextLine();
      for(Account ac:accountArray) {
         if(ac.getNumber().equals(str)) {
            System.out.println("how much minus money?");
            ac.minus(Integer.parseInt(sc.nextLine()));
            break;
         }else
            System.out.println("not found nmber");
      }
   }
   

}