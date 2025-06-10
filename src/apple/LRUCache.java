package apple;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class LRUCache {
    
    // Doubly linked list node
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head; // dummy head
    private final Node tail; // dummy tail
    
    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        // Move accessed node to head (most recently used)
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if (node != null) {
            // Update existing node
            node.value = value;
            moveToHead(node);
        } else {
            // Add new node
            Node newNode = new Node(key, value);
            
            if (cache.size() >= capacity) {
                // Remove least recently used (tail node)
                Node tail = removeTail();
                cache.remove(tail.key);
            }
            
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }
    
    // Helper method: add node right after head
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    // Helper method: remove node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Helper method: move node to head
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    // Helper method: remove and return tail node
    private Node removeTail() {
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
    
    // Test method for LeetCode format
    public static List<Object> executeOperations(String[] operations, Object[][] values) {
        List<Object> result = new ArrayList<>();
        LRUCache cache = null;
        
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "LRUCache":
                    cache = new LRUCache((Integer) values[i][0]);
                    result.add(null);
                    break;
                case "put":
                    cache.put((Integer) values[i][0], (Integer) values[i][1]);
                    result.add(null);
                    break;
                case "get":
                    result.add(cache.get((Integer) values[i][0]));
                    break;
            }
        }
        
        return result;
    }
    
    // Test runner method
    public static void runTests() {
        // Test Case 1
        String[] operations1 = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        Object[][] values1 = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
        List<Object> expected1 = Arrays.asList(null, null, null, 1, null, -1, null, -1, 3, 4);
        List<Object> actual1 = executeOperations(operations1, values1);
        System.out.println("Test Case 1: " + (expected1.equals(actual1) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println(Arrays.toString(operations1));
        System.out.println(Arrays.deepToString(values1));
        System.out.println("Output");
        System.out.println(actual1);
        System.out.println();
        
        // Test Case 2
        String[] operations2 = {"LRUCache", "put", "get", "put", "get", "get"};
        Object[][] values2 = {{1}, {1, 1}, {1}, {2, 2}, {1}, {2}};
        List<Object> expected2 = Arrays.asList(null, null, 1, null, -1, 2);
        List<Object> actual2 = executeOperations(operations2, values2);
        System.out.println("Test Case 2: " + (expected2.equals(actual2) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println(Arrays.toString(operations2));
        System.out.println(Arrays.deepToString(values2));
        System.out.println("Output");
        System.out.println(actual2);
        System.out.println();
        
        // Test Case 3
        String[] operations3 = {"LRUCache", "put", "put", "get"};
        Object[][] values3 = {{2}, {1, 1}, {1, 10}, {1}};
        List<Object> expected3 = Arrays.asList(null, null, null, 10);
        List<Object> actual3 = executeOperations(operations3, values3);
        System.out.println("Test Case 3: " + (expected3.equals(actual3) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println(Arrays.toString(operations3));
        System.out.println(Arrays.deepToString(values3));
        System.out.println("Output");
        System.out.println(actual3);
        System.out.println();
        
        // Test Case 4
        String[] operations4 = {"LRUCache", "put", "put", "get", "get", "put", "get", "get", "get"};
        Object[][] values4 = {{2}, {1, 1}, {2, 2}, {2}, {1}, {3, 3}, {1}, {2}, {3}};
        List<Object> expected4 = Arrays.asList(null, null, null, 2, 1, null, 1, -1, 3);
        List<Object> actual4 = executeOperations(operations4, values4);
        System.out.println("Test Case 4: " + (expected4.equals(actual4) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println(Arrays.toString(operations4));
        System.out.println(Arrays.deepToString(values4));
        System.out.println("Output");
        System.out.println(actual4);
        System.out.println();
        
        // Test Case 5
        String[] operations5 = {"LRUCache", "get", "put", "get"};
        Object[][] values5 = {{3}, {1}, {1, 1}, {1}};
        List<Object> expected5 = Arrays.asList(null, -1, null, 1);
        List<Object> actual5 = executeOperations(operations5, values5);
        System.out.println("Test Case 5: " + (expected5.equals(actual5) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println(Arrays.toString(operations5));
        System.out.println(Arrays.deepToString(values5));
        System.out.println("Output");
        System.out.println(actual5);
        System.out.println();
    }
    
    public static void main(String[] args) {
        runTests();
    }
}
