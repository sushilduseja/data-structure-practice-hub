import java.util.*;

public class FindDistinctPermutations {
    static Set<String> result = new TreeSet<>();

    static void findPermutation(String str, String ans) {
        // If string is empty
        if (str.length() == 0) {
            result.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            findPermutation(ros, ans + ch);
        }
    }

    public static void main(String[] args) {
        checkInputAgainstExpected("O2", create("2O","O2"));
        checkInputAgainstExpected("XYZ", create("XYZ","XZY","YXZ","YZX","ZXY","ZYX"));
        checkInputAgainstExpected("aBc", create("Bac", "Bca", "aBc","acB", "cBa", "caB"));
        //checkInputAgainstExpected("AAA", create("AAA"));
        checkInputAgainstExpected("", create(""));
    }

    static void checkInputAgainstExpected(String input, Set<String> expected) {
        findPermutation(input, "");
        if (expected.equals(result)) {
            System.out.println("ok for input " + input);
        } else {
            System.out.println("expected " + expected + " but got " + result + " for input " + input);
        }
        result.clear();
    }

    static Set<String> create(String... input) {
        Set<String> Set = new TreeSet<>();
        Set.addAll(Arrays.asList(input));
        return Set;
    }
}

