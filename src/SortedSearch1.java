import java.util.Arrays;


public class SortedSearch1 {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        if (sortedArray.length == 0) return 0;
        if (sortedArray[0] >= lessThan) return 0;

        int num = Arrays.binarySearch(sortedArray, lessThan);
        if (num >= 0) {
            return num;
        }
        return (-num) - 1;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
        System.out.println(SortedSearch.countNumbers(new int[]{0}, 0));
        System.out.println(SortedSearch.countNumbers(new int[]{1, 2, 3}, 4));
        System.out.println(SortedSearch.countNumbers(new int[]{5, 7, 12}, 11));
        System.out.println(SortedSearch.countNumbers(new int[]{0, 1, 5, 6, 44, 55, 99, 101}, 100));
        System.out.println(SortedSearch.countNumbers(new int[]{5, 6, 7, 9, 10}, 7));
        System.out.println(SortedSearch.countNumbers(new int[]{6, 7, 8}, 7));
    }
}