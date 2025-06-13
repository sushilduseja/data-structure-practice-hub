package amazon;

/**
 * First Non-Repeating Character Implementation
 *
 * Problem Source: CodeSignal/Amazon Interview Practice
 * Similar to LeetCode Problem #387: First Unique Character in a String
 *
 * Given a string s, find and return the first instance of a non-repeating character in it.
 * If there is no such character, return a special value indicating absence (here, Character.MIN_VALUE).
 *
 * Example:
 * Input: "abacabad" -> Output: 'c'
 * Input: "abacabaabacaba" -> Output: Character.MIN_VALUE
 *
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(k) where k is the size of the character set (constant for ASCII)
 *
 * Common Interview Question At:
 * - Amazon
 * - Microsoft
 * - Facebook
 */

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
