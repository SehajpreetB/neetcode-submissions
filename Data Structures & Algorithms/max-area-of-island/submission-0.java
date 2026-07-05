class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int area = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, bfs(grid, r, c));
                }
            }
        }
        return area;
    }
    private int bfs(int[][] grid,int i, int j){
        Queue<int[]> q=new LinkedList<>();

        grid[i][j]=0;
        q.add(new int[]{i,j});
        int area=1;
        while(!q.isEmpty()){
            int[] ind=q.poll();
            for(int[] dir:directions){
            int r=ind[0]+ dir[0],c=ind[1]+dir[1];

            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1){
                q.add(new int[]{r,c});
                grid[r][c]=0;
                area++;
            }
        }

        }
        
        return area;
    }
}
