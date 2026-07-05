class Solution {
    Set<List<Integer>> set ;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        util(nums,0,list);
        return new ArrayList<>(set);
    }
    public void util(int[] nums,int ind, List<Integer> subset){
        if(ind>= nums.length){
            List<Integer> currSet=new ArrayList<>(subset);
            Collections.sort(currSet);
            set.add(currSet);
            return;
        }

        util(nums,ind+1,subset);
        subset.add(nums[ind]);
        util(nums,ind+1,subset);
        subset.remove(subset.size()-1);


    }
}
