import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LetterChanges {
    public static String LetterChanges(String str) {
        List<Character> vowels = new ArrayList<>(List.of('a','e','i','o','u'));
        // code goes here
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
        StringBuilder builder = new StringBuilder(str.length());
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if(Character.isAlphabetic(temp)) {
                if (chars[i] == 'z') {
                    temp = 'a';
                } else {
                    temp += 1;
                }
                if (vowels.contains(temp)) {
                    temp = Character.toUpperCase(temp);
                }
            }
            builder.append(temp);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterChanges(s.nextLine()));
    }

}