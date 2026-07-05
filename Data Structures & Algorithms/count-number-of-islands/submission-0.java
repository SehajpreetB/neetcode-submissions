class Solution {
    boolean[][] visited;
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]=='0'){
            return;
        }
        visited[i][j]=true;

        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
}
