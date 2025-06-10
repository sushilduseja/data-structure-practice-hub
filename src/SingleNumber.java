public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        java.util.List<Integer> duplicates = new java.util.ArrayList<>();
        java.util.Set<Integer> result = new java.util.HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!result.add(nums[i])) {
                duplicates.add(nums[i]);
            }
        }
        java.util.Set<Integer> difference = new java.util.HashSet<>(result);
        difference.removeAll(duplicates);

        int[] primitive = difference.stream()
                .filter(java.util.Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        return primitive;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        
        int[] a = new int[] {1,2,1,3,2,5};
        System.out.println(sn.singleNumber(a));
    }
}
