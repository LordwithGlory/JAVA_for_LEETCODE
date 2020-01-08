import java.util.Vector;

public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        boolean res=true;
        Vector<Character> exist=new Vector<Character>();
        int row=0;
        int col=0;
        for (;row<9&&res;row++){
            exist.clear();
            for (col=0;col<9&&res;col++){
                char now=board[row][col];
                if (now=='.')
                    continue;
                if (exist.contains(now))
                    res=false;
                else
                    exist.add(now);
            }
        }
        for (col=0;col<9&&res;col++){
            exist.clear();
            for (row=0;row<9&&res;row++){
                char now=board[row][col];
                if (now=='.')
                    continue;
                if (exist.contains(now))
                    res=false;
                else
                    exist.add(now);
            }
        }
        for (col=0;col<9&&res;col+=3){
            for (row=0;row<9&&res;row+=3){
                int tmpcol=col;
                int tmprow=row;
                for (;tmpcol<col+3;tmpcol++){
                    exist.clear();
                    // 这个地方没初始化==
                    for (tmprow=row;tmprow<row+3;tmprow++){
                        char now=board[tmprow][tmpcol];
                        if (now=='.')
                            continue;
                        if (exist.contains(now))
                            res=false;
                        else
                            exist.add(now);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] atgs){
        char[][] test={{'.','.','.','.','5','.','.','1','.' },{'.','4','.','3','.','.','.','.','.' },{'.','.','.','.','.','3','.','.','1' },
                {'8','.','.','.','.','.','.','2','.' },{'.','.','2','.','7','.','.','.','.' },{'.','1','5','.','.','.','.','.','.' },
                {'.','.','.','.','.','2','.','.','.' },{'.','2','.','9','.','.','.','.','.' },{'.','.','4','.','.','.','.','.','.' }};
        Leetcode36 lc=new Leetcode36();
        System.out.println(lc.isValidSudoku(test));
    }
}
