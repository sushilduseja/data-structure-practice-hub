//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class SnakeCase {
//
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        //int T=sc.nextInt();
//        int T = 1;
//        List list = new ArrayList();
//        Scanner sc = new Scanner(System.in).useDelimiter(" ");
//        for(int i=0;i<T;i++) {
//            int N = s.nextInt();
//            //String[] arr = new String[N];
//            StringBuilder tempString = new StringBuilder();
//            for (int j = 0; j < N; j++) {
//                String next = sc.next();
//                tempString.append(next);
//            }
//            //list.add(tempString.toString().toLowerCase().replaceAll("\\s+", "_"));
//            list.add(tempString.toString().toLowerCase().replaceAll(" ", "_"));
//        }
//        for(int i=0;i<list.size();i++) {
//            System.out.println(list.get(i));
//        }
//    }
//}
