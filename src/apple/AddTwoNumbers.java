package apple;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            
            current.next = new ListNode(digit);
            current = current.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
    
    // Helper method to create linked list from array
    private ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }
    
    // Helper method to convert linked list to array for testing
    private int[] listToArray(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    // Test method for LeetCode validation
    public static void runTests() {
        AddTwoNumbers numbers = new AddTwoNumbers();
        
        // Test Case 1
        ListNode l1_1 = numbers.createList(new int[]{2, 4, 3});
        ListNode l2_1 = numbers.createList(new int[]{5, 6, 4});
        ListNode result1 = numbers.addTwoNumbers(l1_1, l2_1);
        int[] expected1 = {7, 0, 8};
        int[] actual1 = numbers.listToArray(result1);
        System.out.println("Test Case 1: " + (java.util.Arrays.equals(actual1, expected1) ? "PASS" : "FAIL"));
        
        // Test Case 2
        ListNode l1_2 = numbers.createList(new int[]{0});
        ListNode l2_2 = numbers.createList(new int[]{0});
        ListNode result2 = numbers.addTwoNumbers(l1_2, l2_2);
        int[] expected2 = {0};
        int[] actual2 = numbers.listToArray(result2);
        System.out.println("Test Case 2: " + (java.util.Arrays.equals(actual2, expected2) ? "PASS" : "FAIL"));
        
        // Test Case 3
        ListNode l1_3 = numbers.createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2_3 = numbers.createList(new int[]{9, 9, 9, 9});
        ListNode result3 = numbers.addTwoNumbers(l1_3, l2_3);
        int[] expected3 = {8, 9, 9, 9, 0, 0, 0, 1};
        int[] actual3 = numbers.listToArray(result3);
        System.out.println("Test Case 3: " + (java.util.Arrays.equals(actual3, expected3) ? "PASS" : "FAIL"));
        
        // Test Case 4
        ListNode l1_4 = numbers.createList(new int[]{5});
        ListNode l2_4 = numbers.createList(new int[]{5});
        ListNode result4 = numbers.addTwoNumbers(l1_4, l2_4);
        int[] expected4 = {0, 1};
        int[] actual4 = numbers.listToArray(result4);
        System.out.println("Test Case 4: " + (java.util.Arrays.equals(actual4, expected4) ? "PASS" : "FAIL"));
        
        // Test Case 5
        ListNode l1_5 = numbers.createList(new int[]{1, 8});
        ListNode l2_5 = numbers.createList(new int[]{0});
        ListNode result5 = numbers.addTwoNumbers(l1_5, l2_5);
        int[] expected5 = {1, 8};
        int[] actual5 = numbers.listToArray(result5);
        System.out.println("Test Case 5: " + (java.util.Arrays.equals(actual5, expected5) ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        runTests();
    }
}