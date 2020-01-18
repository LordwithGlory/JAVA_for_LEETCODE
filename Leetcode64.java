public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        // 最快的那个使用负数表示走过，
        // 使用正数表示没走过，想法有点意思
        int row=grid.length;
        int col=grid[0].length;
        int[][] thecount=new int[row][col];
        thecount[row-1][col-1]=grid[row-1][col-1];
        for (int j=row-1;j>=0;j--){
            // 刚才居然没加上等号
            for (int k=col-1;k>=0;k--){
                if (j==row-1&&k==col-1)
                    continue;
                if (j==row-1){
                    thecount[j][k]=thecount[j][k+1]+grid[j][k];
                    continue;
                }else if (k==col-1){
                    thecount[j][k]=thecount[j+1][k]+grid[j][k];
                    continue;
                }
                thecount[j][k]=grid[j][k]+Math.min(thecount[j+1][k],thecount[j][k+1]);
            }
        }
        return thecount[0][0];
    }
}
