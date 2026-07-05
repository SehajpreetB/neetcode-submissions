class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n];
        Arrays.fill(temp, n);
        temp[0]=0;
        for(int i=0;i<n ;i++){
            int span= Math.min(i+nums[i],n-1);
            for(int j=i+1;j<=span;j++){
                temp[j]=Math.min(temp[j],temp[i]+1);
            }
        }
        return temp[n-1];
    }
}
