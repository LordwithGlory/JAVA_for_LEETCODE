public class Leetcode62 {
    // 简直是一个二维数组就可以解决的问题
    // sigh憨批了
//    public int uniquePaths(int m, int n) {
//        int[][] grid = new int[m][n];
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(i == 0 || j == 0)
//                    grid[i][j] = 1;
//                else
//                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
//            }
//        }
//
//        return grid[m-1][n-1];
//    }
    public int dfs(int leftnum,int upnum,int[][] mypath){
        if (leftnum==0&&upnum==0)
            return 1;
        int res=0;
        if (leftnum>0){
            if (mypath[leftnum-1][upnum]!=0)
                res+=mypath[leftnum-1][upnum];
            else
                res+=dfs(leftnum-1,upnum,mypath);
        }
        if (upnum>0){
            if (leftnum==upnum){
                res*=2;
            }else if (mypath[leftnum][upnum-1]==0)
                res+=dfs(leftnum,upnum-1,mypath);
            else
                res+=mypath[leftnum][upnum-1];
        }
        mypath[leftnum][upnum]=res;
        return res;
    }
    public int uniquePaths(int m, int n) {
        int lefnum=m-1;
        int upnum=n-1;
        if (lefnum==0||upnum==0)
            return 1;
        int[][] mypath=new int[lefnum][upnum];
        return dfs(lefnum,upnum,mypath);
        // 这个狗会超出int范围 sigh
        // 否则一个排列组合就可以解决的问题
//        int res=0;
//        int steps=m+n-2;
//        int[] jc=new int[steps];
//        jc[0]=1;
//        for (int i=1;i<=steps;i++)
//            jc[i]=jc[i-1]*i;
//        res=jc[steps]/(jc[m]*jc[n]);
//        return res;
    }
}
