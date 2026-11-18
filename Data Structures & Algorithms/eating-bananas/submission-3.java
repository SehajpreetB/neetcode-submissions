class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(piles[i],high);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            long currHours=0;
            for(int i=0;i<piles.length;i++){
                currHours+=piles[i]/mid;
                if(piles[i]%mid >0) currHours++;
            }
            if(currHours>h){
                low=mid+1;
            }
            else {
                high=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}
