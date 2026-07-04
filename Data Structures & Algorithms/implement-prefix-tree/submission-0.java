class TrieNode{
    TrieNode[] children=new TrieNode[26];
    Boolean isEnd=false;
}
class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode curr=root;
        for(char a: word.toCharArray()){
            int i=a-'a';
            if(curr.children[i]==null) return false;
            curr=curr.children[i];
        }
        if(curr.isEnd) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char a: prefix.toCharArray()){
            int i=a-'a';
            if(curr.children[i]==null) return false;
            curr=curr.children[i];
        }
        return true;
    }
}
