class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int available=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            available+= (gas[i]-cost[i]);
            if(available<0){
                available=0;
                start=i+1;
            }
        }
        return start; 
        }
}
