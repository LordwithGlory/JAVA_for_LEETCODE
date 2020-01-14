import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<Integer>();
        int row=matrix.length;
        if (row==0)
            return res;
        int col=matrix[0].length;
        boolean[][] hasviewed=new boolean[row][col];
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int mostdir=0;
        int x,y;
        x=y=0;
        int viewnum=0;
        while (true){
            viewnum++;
            hasviewed[x][y]=true;
            res.add(matrix[x][y]);
            if (viewnum==col*row)
                break;
            int nextx=x+dir[mostdir][0];
            int nexty=y+dir[mostdir][1];
            while (nextx>=row||nexty>=col||nextx<0||nexty<0||hasviewed[nextx][nexty]){
                mostdir++;
                mostdir%=4;
                nextx=x+dir[mostdir][0];
                nexty=y+dir[mostdir][1];
            }
            x=nextx;
            y=nexty;
        }
        return res;
    }
}
