class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res= new ArrayList<>();
        List<Integer> com=new ArrayList<>();
        util(nums,0,target,0,com);
        return res;
    }
    public void util(int[] nums, int ind, int target, int sum,List<Integer> com){
        if(sum== target){
            res.add(new ArrayList<>(com));
            return;
        }
        if(ind>= nums.length || sum>target){
            return;
        }
        util(nums,ind+1,target,sum,com);
        com.add(nums[ind]);
        util(nums,ind,target,sum+nums[ind],com);
        com.remove(com.size()-1);
    }
}
