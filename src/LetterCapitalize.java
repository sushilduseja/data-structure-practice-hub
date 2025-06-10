import java.util.*; 
import java.io.*;

class LetterCapitalize {
  public static String LetterCapitalize(String str) { 
  
    // code goes here   
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
       StringBuilder builder = new StringBuilder();
      String[] strings = str.split("\\s+");
      for (String s : strings) {
          String s1 = s.charAt(0)+"";
          s1 = s1.toUpperCase();
          s1 = s1 + s.substring(1) + " ";
          builder.append(s1);
      }

      str = builder.toString();
      return str.substring(0, str.length()-1);
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(LetterCapitalize(s.nextLine())); 
  }   
  
}


  