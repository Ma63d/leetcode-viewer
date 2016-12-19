public class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        this.result = 0;
        boolean[][] board = new boolean[n][n];
        _solve(board,0,n);
        return this.result;
    }

    public void _solve(boolean[][] board, int pos,int n){
        if(pos == n){
            this.result++;
            return;
        }
        for(int i = 0;i < n;i++){
            board[pos][i] = true;
            if(_checkPos(board,pos,i,n)) _solve(board,pos+1,n);
            board[pos][i] = false;
        }
    }
    public boolean _checkPos(boolean[][]board,int x,int y,int n){
        if(x == 0) return true;
        for(int i = 0;i < x;i++){
            if(board[i][y]) return false;
        }
        for(int i = 0;i < n;i++){
            if(i != y && board[x][i]) return false;
        }
        int left = y-1,right = y+1;
        x--;
        while(left >= 0 || right < n){
            if(x < 0) return true;
            if((left >= 0 && board[x][left]) || (right < n && board[x][right])) return false;
            x--;left--;right++;
        }
        return true;
    }
}