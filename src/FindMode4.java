
import java.util.*;
import java.util.concurrent.*;

public class FindMode4 {

    /**
     * @param input list of integers. may be empty. will not be null
     * @return sorted list of numbers making up the Mode of the input.
     * there may be zero, one, or many modes.
     * The Mode is defined as the most frequently occuring number or numbers in an input set of numbers
     */
    public static List<Integer> findMode(List<Integer> input) {
        Map<Integer, Integer> freqBuckets = new HashMap<>();

        for (Integer value : input) {
            if (!freqBuckets.containsKey(value)) {
                freqBuckets.put(value, 1); // +1 to begin with
            } else {
                int newFreq = freqBuckets.get(value) + 1;
                freqBuckets.put(value, newFreq);
            }
        }

        int highestModeOverall = 0;
        List<Integer> valuesWithHighestMode = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freqBuckets.entrySet()) {
            int freq = entry.getValue();

            if (freq > highestModeOverall) {
                highestModeOverall = freq;
                valuesWithHighestMode.clear();
                valuesWithHighestMode.add(entry.getKey());
            } else if (freq == highestModeOverall) {
                valuesWithHighestMode.add(entry.getKey());
            }
        }

        Collections.sort(valuesWithHighestMode);

        return valuesWithHighestMode;
    }

    public static void main(String[] args) {
        checkInputAgainstExpected(create(1, 3, 2, 4, 1), create(1));
        checkInputAgainstExpected(create(1, 2, 4, 3, 1, 2), create(1, 2));
        checkInputAgainstExpected(create(1, 3, 2, 4), create(1, 2, 3, 4));
        checkInputAgainstExpected(create(9, 9, 8, 8), create(8, 9));
        checkInputAgainstExpected(create(9, 9, 9, 8, 8), create(9));
        checkInputAgainstExpected(create(1), create(1));
        checkInputAgainstExpected(create(), create());
    }

    private static void checkInputAgainstExpected(List<Integer> input, List<Integer> expected) {
        List<Integer> output = findMode(input);
        if (expected.equals(output)) {
            System.out.println("ok for input " + input);
        } else {
            System.out.println("expected " + expected + " but got " + output + " for input " + input);
        }
    }

    private static List<Integer> create(Integer... input) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(input));
        return list;
    }

}