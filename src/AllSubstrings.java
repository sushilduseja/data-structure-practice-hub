public class AllSubstrings {
    // Function to print all sub strings
    static void subString(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++)
            for (int j = n; j >= i+1; j--)

                System.out.println(str.substring(i, j));
    }

    // Driver program to test above function
    public static void main(String[] args) {
        String str = "abcd";
        subString(str);

    }
}
