class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2) return 0;
        int[] leftHeight=new int[n];
        leftHeight[0]=0;
        int[] rightHeight=new int[n];
        rightHeight[n-1]=0;
        int maxHeight=0;
        for(int i=1;i<n;i++){
            leftHeight[i]= Math.max(leftHeight[i-1],height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightHeight[i]= Math.max(rightHeight[i+1],height[i+1]);
        }

        int total=0;
        for(int i=1;i<n-1;i++){
            int water= Math.min(leftHeight[i],rightHeight[i]) - height[i];
            if(water>0) total+=water;
        }
        return total;
    }
}
