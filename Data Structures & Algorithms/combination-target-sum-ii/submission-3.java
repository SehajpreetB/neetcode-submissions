class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res= new HashSet<>();
        List<Integer> com=new ArrayList<>();
        Arrays.sort(candidates);
        util(candidates,0,target,0,com);
        return new ArrayList<>(res);
    }
    public void util(int[] nums, int ind, int target, int sum,List<Integer> com){
        if(sum == target){
            res.add(new ArrayList<>(com));
            return;
        }
        
        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            if(sum+nums[i]> target) break;
            com.add(nums[i]);
            util(nums,i+1,target,sum+nums[i],com);
            com.remove(com.size()-1);
        }
    }
}
