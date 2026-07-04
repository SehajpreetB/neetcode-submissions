class Solution {
    public int product(int[] nums,int i,int j){
        int prod=1;
        for(int ind=i;ind<=j;ind++){
            prod*=nums[ind];
        }
        return prod;
    }
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int maxProduct=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int prod= product(nums,i,j);
                maxProduct= Math.max(maxProduct,prod);
            }
        }
        return maxProduct;
    }
}
