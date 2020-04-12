import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {
    public void dfs(int nowrow,boolean[] hasin,int n,List<List<String>> res,int[] rows){
        if (nowrow==n){
            List<String> oneres=new ArrayList<>();
            for (int row=0;row<n;row++){
                String tmp="";
                for (int col=0;col<n;col++){
                    if (col==rows[row]){
                        tmp+="Q";
                        continue;
                    }
                    tmp+=".";
                }
                oneres.add(tmp);
            }
            res.add(oneres);
            return;
        }
        for (int col=0;col<n;col++){
            if (hasin[col])
                continue;
            boolean cancon=true;
            for (int former=0;former<nowrow&&cancon;former++){
                if (Math.abs(nowrow-former)==Math.abs(col-rows[former]))
                    cancon=false;
            }
            if (cancon){
                hasin[col]=true;
                rows[nowrow]=col;
                dfs(nowrow+1,hasin,n,res,rows);
                hasin[col]=false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        boolean[] hasin=new boolean[n];
        int[] eachrol=new int[n];
        int nowrow=0;
        dfs(0,hasin,n,res,eachrol);
        return res;
    }

    public static void main(String[] args){
        Leetcode51 lc=new Leetcode51();
        lc.solveNQueens(1);
    }
}
