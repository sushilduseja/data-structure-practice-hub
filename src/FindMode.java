import java.util.*;

public class FindMode {

    /**
     * @param input list of integers. may be empty. will not be null
     * @return sorted list of numbers making up the Mode of the input.
     * there may be zero, one, or many modes.
     * The Mode is defined as the most frequently occuring number or numbers in an input set of numbers
     */
    public static List<Integer> findMode(List<Integer> input) {

        //TODO complete me!
        Map<Integer, Integer> count = new HashMap<>();

        for(Integer val: input) {

            if (count.get(val)== null) {
                count.put(val,1);

            } else {
                Integer numOfOccurances = count.get(val)+1;

                count.put(val,numOfOccurances);

            }
        }

        int maxCount = 0;

        List<Integer> numbers = new ArrayList<>();

        for (Integer num: count.keySet()) {
            int currentCnt = count.get(num);

            if (maxCount < currentCnt) {

                numbers = new ArrayList<>();
                maxCount = currentCnt;
                numbers.add(num);

            }
            else if (maxCount == currentCnt) {
                numbers.add(num);
            }
        }

        Collections.sort(numbers);

        return numbers;
    }

    public static void main(String[] args) {
        checkInputAgainstExpected(create(1, 3, 2, 4, 1), create(1));
        checkInputAgainstExpected(create(1, 2, 4, 3, 1, 2), create(1, 2));
        checkInputAgainstExpected(create(1, 3, 2, 4), create(1, 2, 3, 4));
        checkInputAgainstExpected(create(9, 9, 8, 8), create(8, 9));
        checkInputAgainstExpected(create(9, 9, 9, 8, 8), create(9));
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
