class Solution {
    
    void dfs(String s, List<String> res, int n,int open,int close) {
        if (n * 2 == s.length()) {
            res.add(s);
            return;
        }
        if(open<n){
            dfs(s + '(', res, n,open+1,close);
        }
        if(close<open){
            dfs(s + ')', res, n,open,close+1);
        }
        return;
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, n,0,0);
        return res;
    }
}
