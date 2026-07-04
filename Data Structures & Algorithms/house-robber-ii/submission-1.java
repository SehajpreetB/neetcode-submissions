class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] arr1= new int[n-1];
        int[] arr2= new int[n-1];

        for(int i=0;i<n-1;i++){
            arr1[i]=nums[i];
            arr2[i]=nums[i+1];
        }

        return Math.max(robUtil(arr1),robUtil(arr2));     
    }
    public int robUtil(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int[] dp=new int[n];
        dp[0]=nums[0];
        if(n==1) return nums[0];

        dp[1]=Math.max(dp[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i]= Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
