class Solution {
    public int maxArea(int[] heights) {
        int i=0,j=heights.length-1;
        int maxWater=0;
        while(i<j){
            int left=heights[i],right=heights[j];
            int water= (j-i)* Math.min(left,right);
            maxWater=Math.max(maxWater,water);
            if(left<right){
                i++;
            }
            else j--;
        }
        return maxWater;
    }
}
