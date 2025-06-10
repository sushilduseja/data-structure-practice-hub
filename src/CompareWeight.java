import java.util.Scanner;

public class CompareWeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        String[] firstArray = new String[T];
        String[] secondArray = new String[T];
        for(int i=0;i<T;i++) {
            firstArray[i] = sc.next();
            secondArray[i] = sc.next();
        }
        for(int i=0;i<T;i++) {
            System.out.println(compare(firstArray[i], secondArray[i]));
        }
    }

    static String compare(String s1, String s2) {
        if(getWeight(s1) > getWeight(s2))
            return "1";
        else if(getWeight(s1) < getWeight(s2))
            return "2";
        else
            return "equal";
    }

    static int getWeight(String s) {
        char[] chars = s.toCharArray();
        int weight = 0;
        for (int i = 0; i < chars.length; i++) {
            weight += getPosition(chars[i]);
        }
        return weight;
    }

    static int getPosition(char c) {
        return c - 'a' + 1;
    }
}
