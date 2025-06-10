import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		if(T<1 || T>100){
		    throw new IllegalArgumentException("Invalid no. of test cases");
		}
		int N;
		for(int i=1;i<=T;i++){
		    N = sc.nextInt();
		    if(N<1 || N>6){
		        System.err.println("Invalid denomination");
		        continue;
		    }
		    System.out.println(7-N);
		}
	}
}