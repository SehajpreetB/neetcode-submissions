class Solution {
    List<List<Integer>> powerset;

public void util(int[] nums, int ind, List<Integer> set) {
    if (ind == nums.length) {
        powerset.add(new ArrayList<>(set));
        return;
    }

    // Don't take current element
    util(nums, ind + 1, set);

    // Take current element
    set.add(nums[ind]);
    util(nums, ind + 1, set);

    // Backtrack
    set.remove(set.size() - 1);
}

public List<List<Integer>> subsets(int[] nums) {
    powerset = new ArrayList<>();
    util(nums, 0, new ArrayList<>());
    return powerset;
}
}
