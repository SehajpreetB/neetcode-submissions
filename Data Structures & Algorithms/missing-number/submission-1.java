class Solution {
    public int missingNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
            xor^=nums[i];
        }
        for(int i=0;i<=nums.length;i++){
            System.out.print(i+" ");
            xor^=i;
        }
        return xor;
    }
}
