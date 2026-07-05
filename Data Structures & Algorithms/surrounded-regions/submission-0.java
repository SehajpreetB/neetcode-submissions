class Solution {
    boolean[][] visited;
    char[][] res;
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]=='X'){
            return;
        }
        visited[i][j]=true;
        res[i][j]='O';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        visited= new boolean[n][m];
        res=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]='X';
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !visited[i][0]){
                dfs(board,i,0);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O' && !visited[i][m-1]){
                dfs(board,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && !visited[0][i]){
                dfs(board,0,i);
            }
        }
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O' && !visited[n-1][i]){
                dfs(board,n-1,i);
            }
        }
        for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        board[i][j] = res[i][j];
    }
}
        return;
    }
}
