public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int count = 0;

        int first = sortedArray[0];
        if(lessThan < first) return 0;

        int last = sortedArray[sortedArray.length-1];
        if(last < lessThan) return sortedArray.length;

        for (int i = 0; i < sortedArray.length; i++) {
            if(sortedArray[i] < lessThan) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 10));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 0));
    }
}