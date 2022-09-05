package practice0901;

import java.util.Arrays;

public class codingtest01 {

   public static void main(String[] args) {
      String[] participant = { "mislav", "stanko", "mislav", "ana" };
      Arrays.sort(participant);

      String[] completion = { "stanko", "ana", "mislav" };
      Arrays.sort(completion);
      int pLength = participant.length;
      int cLength = completion.length;
      String answer = "";

      for (int i = 0; i < completion.length; i++) {
         if (!participant[i].equals(completion[i])) {
            answer = participant[i];
            break;
         } 
         answer = participant[completion.length];
      }
         System.out.println(answer);
      
   }
}