package amazon;

import java.util.HashMap;
import java.util.Map;

class FirstNotRepeatingCharacter {
    static char firstNotRepeatingCharacter(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if(countMap.get(currentChar) == 1) {
                return currentChar;
            }
        }
        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(firstNotRepeatingCharacter(s));

        s = "aa";
        System.out.println(firstNotRepeatingCharacter(s));

        s = "leetcode";
        System.out.println(firstNotRepeatingCharacter(s));

        s = "loveleetcode";
        System.out.println(firstNotRepeatingCharacter(s));

        s = "a@#%121a";
        System.out.println(firstNotRepeatingCharacter(s));
    }

}
