import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class LongestWord {
    public static String LongestWord(String sen) {
        String[] words = sen.split("\\s+");
        List<String> list = Arrays.asList(words);
        list.replaceAll(LongestWord::removePunctuation);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        String largestWord = null;
        int maxLength = list.get(list.size() - 1).length();
        for (String str : list) {
            if (str.length() == maxLength) {
                largestWord = str;
                break;
            }
        }

        return largestWord;
    }

    private static String removePunctuation(String str) {
        return str.replaceAll("\\p{Punct}", "");
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }

}