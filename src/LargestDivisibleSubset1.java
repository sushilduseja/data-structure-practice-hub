import java.util.List;

public class LargestDivisibleSubset1 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();

        List<Pair> pairs = new java.util.ArrayList<>();
        /*for (int i = 0; i < nums.length -1; i++) {
            if ( !((nums[i] % nums[i+1] == 0) || (nums[i+1] % nums[i] == 0)) ) {
                continue;
            }
            pairs.add(new Pair(nums[i], nums[i+1]));
        }
        if ( (nums[0] % nums[nums.length-1] == 0) || (nums[nums.length-1] % nums[0] == 0) ) {
            pairs.add(new Pair(nums[0], nums[nums.length-1]));
        }*/
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if ( !((nums[i] % nums[j] == 0) || (nums[j] % nums[i] == 0)) ) {
                    continue;
                }
                pairs.add(new Pair(nums[i], nums[j]));
            }
        }
        System.out.println(pairs);


       /* for (Pair pair: pairs) {
            set.add(pair.x); set.add(pair.y);
        }*/

       if(pairs.size() == nums.length) {
           return java.util.Arrays.stream(nums).boxed().collect(java.util.stream.Collectors.toList());
       }

        return  new java.util.ArrayList<>(set);
    }

    class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        LargestDivisibleSubset1 largestDivisibleSubset = new LargestDivisibleSubset1();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(nums));

       //nums = new int[]{1,3,6,9};
        //System.out.println(largestDivisibleSubset.largestDivisibleSubset(nums));
    }
}
