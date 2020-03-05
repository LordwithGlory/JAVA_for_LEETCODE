import java.util.LinkedList;
import java.util.Queue;

public class Leetcode130 {
    public void bfs(char[][] board,boolean[][] unchange,int row,int col,int rowlen,int collen){
        Queue<Integer> q=new LinkedList<>();
        int[][] steps={{0,1},{1,0},{0,-1},{-1,0}};
        q.add(row);
        q.add(col);
        unchange[row][col]=true;
        while (!q.isEmpty()){
            row=q.poll();
            col=q.poll();
            for (int i=0;i<4;i++){
                int nextrow=row+steps[i][0];
                int nextcol=col+steps[i][1];
                if (nextcol>=0&&nextcol<collen&&nextrow>=0&&nextrow<rowlen&&board[nextrow][nextcol]=='O'&&!unchange[nextrow][nextcol]){
                    q.add(nextrow);
                    q.add(nextcol);
                    unchange[nextrow][nextcol]=true;
                }
            }
        }
    }
    public void solve(char[][] board) {
        if (board.length==0||board[0].length==0)
            return;
        // 将需要替换的位置设置为true
        // 快的那个是使用*临时代替'O'之后再进行替换
        boolean[][] unchanged=new boolean[board.length][board[0].length];
        int rowlen=board.length;
        int collen=board[0].length;
        for (int row=0;row<rowlen;row++){
            for (int col=0;col<collen;col++){
                if (col==0||row==0||col==collen-1||row==rowlen-1){
                    if (board[row][col]=='O'&&!unchanged[row][col])
                        bfs(board,unchanged,row,col,rowlen,collen);
                }
            }
        }
        for (int row=0;row<rowlen;row++){
            for (int col=0;col<collen;col++){
                if (board[row][col]=='O'&&!unchanged[row][col])
                    board[row][col]='X';
            }
        }
    }
    public static void main(String[] args){
        char[][] b={{'X', 'X', 'X', 'X'},{'X','O','O','X'},{'X','X','O','X'},{'X','X','X','X'}};
        Leetcode130 lc=new Leetcode130();
        lc.solve(b);
    }
}
