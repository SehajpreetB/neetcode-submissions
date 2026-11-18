class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rl=0,rr=matrix.length-1;
        int row=-1;
        while(rl<=rr){
            int rm=(rl+rr)/2;
            if(target<matrix[rm][0]){
                rr=rm-1;
            }
            else if(target>matrix[rm][matrix[0].length-1]){
                rl=rm+1;
            }
            else {
                row=rm;
                break;
            }
        }
        if(row==-1) return false;
        int l=0,r=matrix[0].length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(matrix[row][m]==target) return true;
            else if(matrix[row][m]>target) r=m-1;
            else l=m+1;
        }
        return false;
    }
}
