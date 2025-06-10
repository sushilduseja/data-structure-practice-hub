import java.util.Scanner;

class FirstFactorial {
  public static int FirstFactorial(int num) { 
    if(num == 1) {
      return 1;
    }
    return num * FirstFactorial(num -1);
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    String nextLine = s.nextLine();
    int num = Integer.parseInt(nextLine);
    System.out.print(FirstFactorial(num));
  }   
  
}


  