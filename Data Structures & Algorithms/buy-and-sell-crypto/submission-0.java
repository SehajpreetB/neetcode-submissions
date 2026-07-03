class Solution {
    public int maxProfit(int[] prices) {
        int minValue=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            minValue=Math.min(minValue,prices[i]);
            maxProfit=Math.max(maxProfit, prices[i]-minValue);
        }
        return maxProfit;
    }
}
