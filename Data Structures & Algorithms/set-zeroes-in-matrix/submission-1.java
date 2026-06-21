class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Set<Integer> rowIndex=new HashSet<>();
        Set<Integer> colIndex=new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowIndex.add(i);
                    colIndex.add(j);
                }
            }
        }
        for(Integer ind:rowIndex){
            for(int i=0;i<n;i++){
                matrix[ind][i]=0;
            }
        }
        for(Integer ind:colIndex){
            for(int i=0;i<m;i++){
                matrix[i][ind]=0;
            }
        }
    }
}
