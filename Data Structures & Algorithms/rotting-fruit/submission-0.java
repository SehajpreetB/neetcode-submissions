class Solution {

    private static final int[][] directions = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Add all rotten oranges
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0)
            return 0;

        int minutes = 0;

        while(!q.isEmpty() && fresh>0){

            int size = q.size();

            for(int k=0;k<size;k++){

                int[] curr = q.poll();

                for(int[] d : directions){

                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];

                    if(ni>=0 && nj>=0 &&
                       ni<rows && nj<cols &&
                       grid[ni][nj]==1){

                        grid[ni][nj]=2;
                        fresh--;

                        q.offer(new int[]{ni,nj});
                    }
                }
            }

            minutes++;
        }

        return fresh==0 ? minutes : -1;
    }
}
