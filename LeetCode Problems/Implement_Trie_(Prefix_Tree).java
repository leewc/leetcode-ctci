class TrieNode {
    // Initialize your data structure here.
    //can store the value (char), but is not needed since we can leverage on 0-25 indexes for 26 chars
    
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        //might beed to do to lowercase
        for(char c : word.toCharArray()) {
            if(current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode result = find(word);
        if(result == null)
            return false;
        return result.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode result = find(prefix);
        if(result == null)
            return false;
        return true;
    }
    
    //helper function to find a TrieNode, return null if doesn't exist
    private TrieNode find(String word) {
        if(root == null)
            return null;
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(current.children[c - 'a'] == null)
                return null;
            current = current.children[c - 'a'];
        }
        return current;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");