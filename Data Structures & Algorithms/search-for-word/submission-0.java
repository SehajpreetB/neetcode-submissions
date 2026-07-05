class Solution {
    private int ROWS, COLS;
   private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (util(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean util(char[][] board, String word,int i,int j,int ind){
        if(ind == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>= board[0].length || 
            board[i][j]!= word.charAt(ind) || 
            visited[i][j]) return false;

        visited[i][j]=true;
        boolean res= util(board,word,i+1,j,ind+1) || 
            util(board,word,i,j+1,ind+1) ||
            util(board,word,i-1,j,ind+1) ||
            util(board,word,i,j-1,ind+1);
        visited[i][j]=false;
        return res;
    }
}
