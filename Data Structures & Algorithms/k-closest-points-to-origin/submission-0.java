class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap=
            new PriorityQueue<>((a,b)->(b[0]-a[0]));
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist= x*x + y*y;
            heap.offer(new int[]{dist,x,y});
        }
        while(heap.size()>k){
            heap.poll();
        }
        int[][] res=new int[k][2];
        int ind=0;
        while(heap.size()>0){
            int[] element=heap.poll();
            res[ind][0]=element[1];
            res[ind][1]=element[2];
            ind++;
        }
        return res;
    }
}
