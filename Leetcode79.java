public class Leetcode79 {
    int[][] step={{0,1},{1,0},{0,-1},{-1,0}};
    public boolean dfs(char[][]board,boolean[][] hasviewed,String word,int x,int y){
        if (word.length()==0)
            return true;
        for (int i=0;i<4;i++){
            int tmpx=x+step[i][0];
            int tmpy=y+step[i][1];
            if (tmpx<board.length&&tmpx>=0&&tmpy<board[0].length&&tmpy>=0&&!hasviewed[tmpx][tmpy]){
                if (board[tmpx][tmpy]==word.charAt(0)){
                    hasviewed[tmpx][tmpy]=true;
                    if (dfs(board,hasviewed,word.substring(1,word.length()),tmpx,tmpy)){
                        return true;
                    }
                    hasviewed[tmpx][tmpy]=false;
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean res=false;
        boolean[][] hasviewed=new boolean[board.length][board[0].length];
        for (int row=0;row<board.length&&!res;row++){
            for (int col=0;col<board[0].length&&!res;col++){
                if (board[row][col]==word.charAt(0)){
                    hasviewed[row][col]=true;
                    if (dfs(board,hasviewed,word.substring(1,word.length()),row,col)){
                        return true;
                    }
                    hasviewed[row][col]=false;
                }
            }
        }
        return false;
    }
}
