package amazon;

public class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                node.setNode(ch, new TrieNode());
            }
            node = node.getNode(ch);
        }
        node.setEnd(true);
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i <prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(node.containsKey(ch)) {
                node = node.getNode(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean isFound(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode != null && trieNode.isEnd();
    }

    public boolean isStartsWith(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode != null;
    }
}
