public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] res=new int[row][col];
        res[row-1][col-1]=1;
        for (int j=row-1;j>=0;j--){
            for (int k=col-1;k>=0;k--){
                if (obstacleGrid[j][k]==1){
                    res[j][k]=0;
                    continue;
                }
                if (j==row-1&&k==col-1)
                    continue;
                if (j==row-1){
                    res[j][k]=res[j][k+1];
                    continue;
                }
                if (k==col-1){
                    res[j][k]=res[j+1][k];
                    continue;
                }
                res[j][k]=res[j+1][k]+res[j][k+1];

            }
        }
        return res[0][0];
    }
}
