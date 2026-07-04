class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length, n=matrix[0].length;
        int lr=0,rr=m-1;

        while(lr<=rr){
            int mid= (lr+rr)/2;

            if(target>= matrix[mid][0] && target<= matrix[mid][n-1]){
                // regular BS
                int l=0,r=n-1;
                while(l<=r){
                    int cur=(l+r)/2;
                    if(matrix[mid][cur]== target) return true;
                    else if(matrix[mid][cur]> target) r=cur-1;
                    else l=cur+1;
                }
                return false;
            }
            else if(target<matrix[mid][0]){
                rr=mid-1;
            }
            else lr=mid+1;
        }
        return false;
    }
}
