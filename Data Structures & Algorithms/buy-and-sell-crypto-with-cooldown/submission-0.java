class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return dfs(prices,1,0);
    }
    public int dfs(int[] prices,int state, int i){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][state]!=-1){
            return dp[i][state];
        }
        //don't do anything
        int skip= dfs(prices,state,i+1);
        //buying
        if(state==1){
            // sell it, change state to 1.
            int buy= dfs(prices,0,i+1)-prices[i];
            return dp[i][state]=Math.max(skip,buy);

        }
        else{
            int sell= dfs(prices,1,i+2)+prices[i];
            return dp[i][state]=Math.max(skip,sell);
        }
    }
}
