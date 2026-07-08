class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            for(int j=0;j<word2.length();j++){
                dp[i][j]=-1;
            }
        }
        return util(word1,word2,0,0);
    }
    public int util(String word1,String word2,int i,int j){
        if(i==word1.length()){
            return word2.length()-j;
        }
        if(j==word2.length()){
            return word1.length()-i;
        }
        if(word1.charAt(i)== word2.charAt(j)){
            return dp[i][j]=util(word1,word2,i+1,j+1);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int res= Math.min(
            // insert character
            util(word1,word2,i+1,j),
            Math.min(
                // remove character
                util(word1,word2,i,j+1),
                //replace character
                util(word1,word2,i+1,j+1)
            ));
        return dp[i][j]=res+1;
    }
}
