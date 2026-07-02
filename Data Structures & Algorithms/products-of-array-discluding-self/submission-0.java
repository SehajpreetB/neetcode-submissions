class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        if(n==0) return new int[0];
        if(n==1) return new int[]{1};
        int[] prefixProd= new int[n];
        int[] postfixProd= new int[n];
        int prev=1;
        for(int i=0;i<n;i++){
            prefixProd[i]=nums[i]*prev;
            prev=prefixProd[i];
        }
        prev=1;
        for(int i=n-1;i>=0;i--){
            postfixProd[i]=nums[i]*prev;
            prev=postfixProd[i];
        }
        int[] ans=new int[n];
        ans[0] = postfixProd[1];
        ans[n - 1] = prefixProd[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = prefixProd[i - 1] * postfixProd[i + 1];
        }
        return ans;
    }
}  
