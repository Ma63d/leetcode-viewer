public class Solution {
    //不知道为什么 很简单一道BFS的题
    //我在IDE里面跑我的代码都能跑对 在leetcode上就是死活不对
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][col-1] == 'O')
                dfs(board, i, col-1);
        }
        for (int i = 1; i < col - 1; i++){
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[row - 1][i] == 'O')
                dfs(board,row-1, i);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        return;
        
    }
    public void dfs(char[][] board, int m, int n) {
        if (board[m][n] != 'O') return;
        board[m][n] = '1';
        if (m < board.length - 2)
            dfs(board, m + 1, n);
        if (m > 1)
            dfs(board, m - 1, n);
        if (n < board[0].length - 2)
            dfs(board, m, n + 1);
        if (n > 1)
            dfs(board, m, n - 1);
        
    }
}