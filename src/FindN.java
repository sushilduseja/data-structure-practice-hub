import java.util.Scanner;

class FindN {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        if(T<1 || T>100){
            throw new IllegalArgumentException("Invalid no. of test cases");
        }
        for(int i=0;i<T;i++) {
            int N = sc.nextInt();
            if(N<1 || N>1000){
                System.err.println("Invalid N");
                continue;
            }
            int result = calculate(N);
            System.out.println(result);
        }
    }

    static int calculate(int n){
        if(n==1){
            return 1;
        }
        return calculate(n-1) + n;
    }
}