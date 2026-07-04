class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean isEnd=false;
}
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char a : word.toCharArray()){
            int i=a-'a';
            if(curr.children[i]==null){
                curr.children[i]=new TrieNode();
            }
            curr=curr.children[i];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.isEnd;
    }
}
