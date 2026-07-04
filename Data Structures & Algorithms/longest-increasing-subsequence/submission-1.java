class Solution {
    int[][] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length][nums.length + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int i, int prev) {
        if (i == nums.length) return 0;
        if (memo[i][prev + 1] != -1) return memo[i][prev + 1];

        int skip = dfs(nums, i + 1, prev);

        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + dfs(nums, i + 1, i);
        }

        return memo[i][prev + 1] = Math.max(skip, take);
    }
}
