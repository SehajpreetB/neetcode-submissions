class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int m = l + (r - l) / 2;

            if (nums[m] > nums[r]) {
                // Minimum is in the right half
                l = m + 1;
            } else {
                // Minimum is at m or in the left half
                r = m;
            }
        }

        return nums[l];
    }
}
