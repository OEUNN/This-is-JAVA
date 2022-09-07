package practice0906.exam01;

public class Account {
   private String number;//계좌번호
   private String name;//계좌주
   private int balance;//계좌 입금액
   
   
   public String getNumber() {
      return number;
   }
   public void setNumber(String number) {
      this.number=number;
   }
   
   public String getName(){
      return name;
   }
   public void setName(String name){
      this.name=name;
   }
   
   public int getBalance() {
      return balance;
   }
   public void setBalance(int balance) {
      this.balance=balance;
   }
   
   public void addMoney(int money) {
      this.balance+=money;
   }
   public void minus(int money) {
      this.balance-=money;
   }

}