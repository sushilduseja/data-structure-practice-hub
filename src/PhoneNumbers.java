import java.util.*;

public class PhoneNumbers {
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> preResult = new ArrayList<String>();
        result.add("");

        for(int i = 0; i < digits.length(); i++) {
            String letters = map.get(digits.charAt(i));
            for(String str : result) {
                for(int j = 0; j < letters.length(); j++)
                    preResult.add(str + letters.charAt(j));
            }
            result = preResult;
            preResult = new ArrayList<String>();
        }
        return result;
    }

    static final HashMap<Character,String> map = new HashMap<Character,String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }} ;

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
