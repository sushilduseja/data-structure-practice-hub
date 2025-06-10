import java.util.*; 
import java.io.*;

class SimpleAdding {
  public static int SimpleAdding(int num) {
    int sum = 0;
    /*for (int i = num; i >=1; i--) {
      sum += i;
    }*/
    for (int i = 1; i <=num; i++) {
      sum += i;
    }
       
    return sum;
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    String nextLine = String.valueOf(s.nextLine());
    int num = Integer.parseInt(nextLine);
    System.out.print(SimpleAdding(num));
  }   
  
}
