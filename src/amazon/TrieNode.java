package amazon;

public class TrieNode {
    TrieNode[] links;
    boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public TrieNode getNode(char ch) {
        return links[ch - 'a'];
    }

    public void setNode(char ch, TrieNode trieNode) {
        links[ch - 'a'] = trieNode;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
}
