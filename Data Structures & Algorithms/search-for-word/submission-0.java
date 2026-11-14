class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        int[] delRow={-1, 0, 1, 0};
        int[] delCol={0, 1, 0, -1};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(dfs(board, word, vis, delRow, delCol, n, m, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] vis, 
    int[] delRow, int[] delCol, int n, int m, int row, int col, int pos) {
        if(pos==word.length()-1) {
            return true;
        }
        vis[row][col]=true;
        for(int i=0; i<4; i++) {
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && 
            board[nrow][ncol]==word.charAt(pos+1)) {
                if(dfs(board, word, vis, delRow, delCol, n, m, nrow, ncol, pos+1)) {
                    return true;
                }
            }
        }
        vis[row][col]=false;
        return false;
    }
}
