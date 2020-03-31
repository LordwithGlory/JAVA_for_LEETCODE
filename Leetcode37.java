import java.util.HashSet;
import java.util.Set;

public class Leetcode37 {
    public boolean fullsud(char[][] board,Set<Character>[] x_set,Set<Character>[] y_set,Set<Character>[] s_set,int x,int y){
        if (x>=board.length||y>=board[0].length)
            return true;
        if (board[x][y]=='.'){
            for (int pos=0;pos<10;pos++){
                char c=(char)(pos+48);
                int s=y/3+x-x%3;
                if (x_set[x].contains(c)||y_set[y].contains(c)||s_set[s].contains(c))
                    continue;
                x_set[x].add(c);
                y_set[y].add(c);
                s_set[s].add(c);
                board[x][y]=c;
                if (y==board.length-1&&fullsud(board,x_set,y_set,s_set,x+1,0))
                    return true;
                else if (y!=board.length-1&&fullsud(board,x_set,y_set,s_set,x,y+1))
                    return true;
                x_set[x].remove(c);
                y_set[y].remove(c);
                s_set[s].remove(c);
            }
            board[x][y]='.';
            return false;
        }else{
            if (y==board.length-1){
                return fullsud(board,x_set,y_set,s_set,x+1,0);
            }else {
                return fullsud(board,x_set,y_set,s_set,x,y+1);
            }
        }
    }
    public void solveSudoku(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        Set<Character>[] x_set=new HashSet[board.length];
        Set<Character>[] y_set=new HashSet[board[0].length];
        Set<Character>[] s_set=new HashSet[9];
        for (int x=0;x<row;x++){
            for (int y=0;y<col;y++){
                int nows=y/3+x-x%3;
                if (x_set[x]==null)
                    x_set[x]=new HashSet<>();
                if (y_set[y]==null)
                    y_set[y]=new HashSet<>();
                if (s_set[nows]==null)
                    s_set[nows]=new HashSet<>();
                char c=board[x][y];
                if (c!='.'){
                    if (x_set[x].contains(c)||y_set[y].contains(c)||s_set[nows].contains(c))
                        return;
                    x_set[x].add(c);
                    y_set[y].add(c);
                    s_set[nows].add(c);
                }
            }
        }
        fullsud(board,x_set,y_set,s_set,0,0);
    }
}
