package amazon;

import java.util.Arrays;

public class AggregateTemperature {
    public static void main(String[] args) {
        // Example temperature changes
        int[] tempChange = {-1, 2, 3};
//        int[] tempChange = {6, -2, 5};

        // Find the maximum aggregate temperature change
        long maxTempChange = aggregateTempChange(tempChange, tempChange.length);

        // Print the result
        System.out.println("Maximum aggregate temperature change: " + maxTempChange);
    }

    public static long aggregateTempChange(int[] arr, int n) {
        int[] pre_sum = new int[arr.length];
        pre_sum[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            pre_sum[i] = arr[i] + pre_sum[i-1];
        }
        int max_agg = pre_sum[arr.length-1];
        for(int i=1;i<arr.length-1;i++){
            int tmp = Math.max(pre_sum[i], pre_sum[arr.length-1] -pre_sum[i-1]);
            max_agg = Math.max(tmp, max_agg);
        }

        return max_agg;
    }
}




