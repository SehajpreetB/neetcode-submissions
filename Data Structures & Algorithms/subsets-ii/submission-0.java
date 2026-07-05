class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        int n=nums.length;
        int s= 1<<n;
        for(int i=0;i<s;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    temp.add(nums[j]);
                }
            }
            Collections.sort(temp);
            set.add(temp);
        }
        return new ArrayList<>(set);
    }
}
