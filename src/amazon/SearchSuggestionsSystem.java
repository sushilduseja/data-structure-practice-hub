package amazon;

/**
 * Search Suggestions System Implementation
 *
 * Problem Source: LeetCode Problem #1268
 * Original Problem: https://leetcode.com/problems/search-suggestions-system/
 *
 * This implementation uses a Trie (prefix tree) data structure to efficiently
 * store and retrieve product suggestions. The solution demonstrates a common
 * interview problem that tests understanding of Trie implementation and DFS.
 *
 * Time Complexity:
 * - Building Trie: O(n * L) where n is number of products, L is average length
 * - Search: O(M * L) where M is length of searchWord
 *
 * Space Complexity: O(26 * N) where N is total number of nodes in Trie
 *
 * Common Interview Question At:
 * - Amazon
 * - Google
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Custom class Trie with function to get 3 words starting with given prefix
class MyTrie {

    // Node definition of a trie
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    }

    Node Root, curr;
    List<String> resultBuffer;

    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    void dfsWithPrefix(Node curr, String word) {
        if (resultBuffer.size() == 3)
            return;
        if (curr.isWord)
            resultBuffer.add(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++)
            if (curr.children.get(c - 'a') != null)
                dfsWithPrefix(curr.children.get(c - 'a'), word + c);
    }

    MyTrie() {
        Root = new Node();
    }

    // Inserts the string in trie.
    void insert(String s) {

        // Points curr to the root of trie.
        curr = Root;
        for (char c : s.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                curr.children.set(c - 'a', new Node());
            curr = curr.children.get(c - 'a');
        }

        // Mark this node as a completed word.
        curr.isWord = true;
    }

    List<String> getWordsStartingWith(String prefix) {
        curr = Root;
        resultBuffer = new ArrayList<String>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                return resultBuffer;
            curr = curr.children.get(c - 'a');
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
}

public class SearchSuggestionsSystem {
    static List<List<String>> suggestedProducts(String[] products,
                                                String searchWord) {
        MyTrie trie = new MyTrie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = new String[]{
            "mobile", "mouse", "moneypot", "monitor", "mousepad"
        } ;
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord));
    }
}