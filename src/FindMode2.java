


import java.util.*;
import java.util.stream.*;

public class FindMode2 {

    /**
     * @param input list of integers. may be empty. will not be null
     * @return sorted list of numbers making up the Mode of the input.
     * there may be zero, one, or many modes.
     * The Mode is defined as the most frequently occuring number or numbers in an input set of numbers
     */
    public static List<Integer> findMode(List<Integer> input) {


        List<Integer> res = new ArrayList<>();

        if(input.size() == 0){
            return res;
        }

        Map<Integer, Integer> m = new HashMap<>();

        for(int i: input){

            m.merge(i, 1, Integer::sum);

        }

        final int max = m.values().stream().max(Integer::compare).get();

        // for(Map.Entry<Integer, Integer> e :m.entrySet()){
        //   if(e.getValue() == max){
        //     res.add(e.getKey());
        //   }
        // }

        return m.entrySet().stream().filter(entry -> entry.getValue() == max).map(e -> e.getKey()).collect(Collectors.toList());
        //TODO complete me!
        // return res;


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
