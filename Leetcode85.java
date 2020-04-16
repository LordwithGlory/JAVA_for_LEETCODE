public class Leetcode85 {
    public int maximalRectangle(char[][] matrix) {
        // 可以通过downnum成为一个个直方图
        int rowlen=matrix.length;
        if (rowlen==0)
            return 0;
        int[][] downnum=new int[rowlen][matrix[0].length];
        int res=0;
        for (int col=0;col<matrix[0].length;col++){
            int downone=0;
            for (int row=rowlen-1;row>=0;row--){
                if (matrix[row][col]=='0'){
                    downone=0;
                    continue;
                }
                downone++;
                res=Math.max(res,downone);
                downnum[row][col]=downone;
            }
        }
        for (int row=0;row<rowlen;row++){
            for (int col=0;col<matrix[0].length;col++){
                if (col>0&&downnum[row][col]<=downnum[row][col-1])
                    continue;
                if (matrix[row][col]=='0')
                    continue;
                int area=downnum[row][col];
                int mindown=area;
                for (int nextcol=col+1;nextcol<matrix[0].length;nextcol++){
                    if (matrix[row][nextcol]=='0')
                        break;
                    mindown=Math.min(mindown,downnum[row][nextcol]);
                    res=Math.max(res,mindown*(nextcol+1-col));
                }
            }
        }
        return res;
    }
}
