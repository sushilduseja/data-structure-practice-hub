import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMode3 {

    /**
     * @param input list of integers. may be empty. will not be null
     * @return sorted list of numbers making up the Mode of the input.
     * there may be zero, one, or many modes.
     * The Mode is defined as the most frequently occuring number or numbers in an input set of numbers
     */
    public static List<Integer> findMode(List<Integer> input) {

        Map<Integer,Long> countMap =input.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer> output=new ArrayList<>();

        Optional<Long> maxFreqOpt=countMap.values().stream().max(Long::compare);

        if(maxFreqOpt.isEmpty()){
            return output;
        }

        Long maxFreq=maxFreqOpt.get();

        for(Map.Entry<Integer,Long> entry:countMap.entrySet())
        {
            if(entry.getValue()==maxFreq){
                output.add(entry.getKey());
            }
        }

        return output;
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
