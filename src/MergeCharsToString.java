import java.util.Scanner;

public class MergeCharsToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            char[] arr = new char[N];
            for (int i = 0; i < N; i++) {
                String next = sc.next();
                next = next.trim();
                arr[i] = next.toCharArray()[0];
            }

            System.out.println(String.valueOf(arr));
        }
    }
}

