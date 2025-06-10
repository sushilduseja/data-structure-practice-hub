import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public static List<String> wordSubsets(String[] A, String[] B) {
        ArrayList<String> result = new ArrayList<String>();

        for (int j = 0; j < A.length; j++) {
            String a = A[j];
            int outerCount = 0;
            outer:
            for (int i = 0; i < B.length; i++) {
                String b = B[i];
                char[] bChars = b.toCharArray();
                int count = 0;
                for (int k = 0; k < bChars.length; k++) {
                    char bChar = bChars[k];
                    if (!a.contains(String.valueOf(bChar))) {
                        break outer;
                    } else {
                        count++;
                    }
                }
                if (count == bChars.length) {
                    outerCount++;
                }
            }
            if(outerCount == B.length) {
                result.add(a);
            }
        }

        return result;
    }

    public static void main(String[] args) {
       /* String[] A = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = new String[]{"lo", "eo"};
        System.out.println(wordSubsets(A, B));*/


        String[] A = new String[]{"leetcode"};
        String[] B = new String[]{"e","oo"};
        System.out.println(wordSubsets(A, B));

       /* A = new String[]{"amazon","apple","facebook","google","leetcode"};
        B = new String[]{"ec","oc","ceo"};
        System.out.println(wordSubsets(A, B));*/

    }
}
