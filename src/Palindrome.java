public class Palindrome {
    public static boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        for (int i = chars.length -1; i >= 0; i--) {
            chars[chars.length - i - 1] = chars[i];
        }
        String reverse = String.valueOf(chars);
        if(word.equalsIgnoreCase(reverse)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("ded"));
    }
}