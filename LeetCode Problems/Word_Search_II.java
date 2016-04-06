public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = buildTree(words);
        List<String> results = new ArrayList<>();
        //because I dislike having to modify the original board
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, visited, results);
            }
        }
        return results;
    }
    
    
    private void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited, List<String> result) {
        char c = board[i][j];
        if(visited[i][j] || node.children[c - 'a'] == null) 
            return;
            
        node = node.children[c - 'a']; //move down the Trie, missed this step!
        
        
        if(node.word != null) { //found a word
            result.add(node.word);
            node.word = null;   //remove so we don't get duplicates in the result
        }
        
        visited[i][j] = true;
        if(i > 0)                   dfs(board, i - 1, j, node, visited, result);
        if(j > 0)                   dfs(board, i, j - 1, node, visited, result);
        if(i < board.length - 1)    dfs(board, i + 1, j, node, visited, result);
        if(j < board[0].length - 1) dfs(board, i, j + 1, node, visited, result);
        visited[i][j] = false;
    }
    
    //creates a Trie and returns the root with all the words
    private TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        
        for(String word : words) {
            TrieNode current = root;
            //build the trie for each char in the word
            for(char c : word.toCharArray()) {
                int index = c - 'a';
                if(current.children[index] == null)
                    current.children[index] = new TrieNode();
                current = current.children[index];
            }
            current.word = word; //store the word in the leaf
        }
        
        return root;
    }
}

class TrieNode {
    String word; //store the entire word here to avoid duplicates
    TrieNode[] children; 
    
    public TrieNode() {
        word = null;
        children = new TrieNode[26];
    }
}