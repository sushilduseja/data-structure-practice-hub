import java.util.Scanner;

class SimpleSymbols {
    public static String SimpleSymbols(String str) {
        boolean isNotFound = false;
        char[] chars = str.toCharArray();
        char first = chars[0];
        char last = chars[chars.length-1];
        if(Character.isAlphabetic(first) || Character.isAlphabetic(last)) {
            return "false";
        }
        for (int i = 1; i < chars.length-1; i++) {
            if(Character.isAlphabetic(chars[i])) {
                if(chars[i-1] != '+' || chars[i+1] != '+') {
                    isNotFound = true;
                    break;
                }
            }
        }
        return isNotFound ? "false" : "true";
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SimpleSymbols(s.nextLine()));
    }

}


  