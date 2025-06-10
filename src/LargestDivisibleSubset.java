public class LargestDivisibleSubset {

    public java.util.List<Integer> largestDivisibleSubset(int[] nums) {

        java.util.Set<java.util.Set> possibilities = new java.util.HashSet<>();

        for (int i = 0; i < nums.length ; i++) {
            java.util.Set<Integer> set = new java.util.HashSet<>();
            for (int j = 0; j < nums.length ; j++) {
                if ( /*i==j ||*/ ((nums[i] % nums[j] == 0) || (nums[j] % nums[i] == 0)) ) {
                    continue;
                }
                set.add(nums[j]);
            }
            possibilities.add(set);
        }
        System.out.println(possibilities);

        return  new java.util.ArrayList<>();
    }


    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        int[] nums = new int[]{1,2,3};
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(nums));

       //nums = new int[]{1,3,6,9};
        //System.out.println(largestDivisibleSubset.largestDivisibleSubset(nums));
    }
}
