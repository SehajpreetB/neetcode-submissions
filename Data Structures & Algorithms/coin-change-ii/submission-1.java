public class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }

        return dfs(coins, 0, amount);
    }

    private int dfs(int[] coins, int i, int a) {
        if (a == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }
        if(dp[i][a]!=-1) return dp[i][a];

        int res = 0;
        if (a >= coins[i]) {
            res = dfs(coins, i + 1, a);
            res += dfs(coins, i, a - coins[i]);
        }
        return dp[i][a]=res;
    }
}