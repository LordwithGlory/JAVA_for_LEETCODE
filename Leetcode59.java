public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        if (n==0)
            return res;
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        int now=1;
        int max=n*n;
        int nowdir=0;
        for (int x=0,y=0;now<=max;now++){
            res[x][y]=now;
            int tmpx,tmpy;
            tmpx=x+dir[nowdir][1];
            tmpy=y+dir[nowdir][0];
            if (tmpx<0||tmpy<0||tmpx>=n||tmpy>=n||res[tmpx][tmpy]!=0){
                nowdir++;
                nowdir%=4;
                tmpx=x+dir[nowdir][1];
                tmpy=y+dir[nowdir][0];
            }
            x=tmpx;
            y=tmpy;
        }
        return res;
    }
}
