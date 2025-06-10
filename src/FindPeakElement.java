public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int index = 0;

        if(nums.length == 1) {
            return 0;
        } else if(nums.length == 2) {
            return nums[1] > nums[0] ? 1 : 0;
        } else if(nums[nums.length-1] > nums[nums.length-2] && nums[nums.length-1] > nums[nums.length-3]) {
            return nums.length-1;
        }
        for (int i = 1; i < nums.length-1; i++) {

            if(nums[i] != nums[i+1] && nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = new int[] {1};
        System.out.println(findPeakElement.findPeakElement(nums));

        nums = new int[] {1, 1, 1};
        System.out.println(findPeakElement.findPeakElement(nums));
    }

}
