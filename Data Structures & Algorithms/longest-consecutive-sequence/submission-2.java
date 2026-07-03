class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int ans=1;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(set.contains(n-1)){
                int len=1;
                while(set.contains(n)){
                    len++;
                    n++;
                }
                ans=Math.max(ans,len);
            }
        }
        return ans;
    }
}
