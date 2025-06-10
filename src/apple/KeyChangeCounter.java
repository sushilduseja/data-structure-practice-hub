package apple;

class KeyChangeCounter {
    public int countKeyChanges(String s) {
        // Input validation (though constraints guarantee non-empty string)
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        int keyChanges = 0;
        
        // Compare each character with the previous one (case-insensitive)
        for (int i = 1; i < s.length(); i++) {
            char currentChar = Character.toLowerCase(s.charAt(i));
            char previousChar = Character.toLowerCase(s.charAt(i - 1));
            
            // If the lowercase versions are different, it's a key change
            if (currentChar != previousChar) {
                keyChanges++;
            }
        }
        
        return keyChanges;
    }
    
    // Alternative implementation using enhanced for loop with indexing
    public int countKeyChangesAlternative(String s) {
        if (s.length() <= 1) return 0;
        
        int changes = 0;
        char[] chars = s.toCharArray();
        
        for (int i = 1; i < chars.length; i++) {
            if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[i-1])) {
                changes++;
            }
        }
        
        return changes;
    }
    
    // Compact one-liner approach for demonstration
    public int countKeyChangesOneLiner(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            count += Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i-1)) ? 1 : 0;
        }
        return count;
    }
    
    // Test method for LeetCode validation
    static public void runTests() {
        KeyChangeCounter keyChangeCounter = new KeyChangeCounter();
        
        // Test Case 1
        String s1 = "aAbBcC";
        int result1 = keyChangeCounter.countKeyChanges(s1);
        System.out.println("Test Case 1: " + (result1 == 2 ? "PASS" : "FAIL") + 
                          " (Expected: 2, Got: " + result1 + ")");
        
        // Test Case 2
        String s2 = "AaAaAaaA";
        int result2 = keyChangeCounter.countKeyChanges(s2);
        System.out.println("Test Case 2: " + (result2 == 0 ? "PASS" : "FAIL") + 
                          " (Expected: 0, Got: " + result2 + ")");
        
        // Test Case 3
        String s3 = "a";
        int result3 = keyChangeCounter.countKeyChanges(s3);
        System.out.println("Test Case 3: " + (result3 == 0 ? "PASS" : "FAIL") + 
                          " (Expected: 0, Got: " + result3 + ")");
        
        // Test Case 4
        String s4 = "abcdef";
        int result4 = keyChangeCounter.countKeyChanges(s4);
        System.out.println("Test Case 4: " + (result4 == 5 ? "PASS" : "FAIL") + 
                          " (Expected: 5, Got: " + result4 + ")");
        
        // Test Case 5
        String s5 = "AAaa";
        int result5 = keyChangeCounter.countKeyChanges(s5);
        System.out.println("Test Case 5: " + (result5 == 0 ? "PASS" : "FAIL") + 
                          " (Expected: 0, Got: " + result5 + ")");
        
        // Test Case 6
        String s6 = "aAbBaAbB";
        int result6 = keyChangeCounter.countKeyChanges(s6);
        System.out.println("Test Case 6: " + (result6 == 3 ? "PASS" : "FAIL") +
                          " (Expected: 3, Got: " + result6 + ")");
    }

    public static void main(String[] args) {
        runTests();
    }
}