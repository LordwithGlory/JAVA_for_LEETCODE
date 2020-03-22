public class Leetcode200 {
    // 比较快的那个直接设置为'0'不需要辅助数组
    //
    public void view(int x,int y,char[][] grid,boolean[][] hasviewed){
        hasviewed[x][y]=true;
        if (x+1<grid.length&&grid[x+1][y]=='1'&&!hasviewed[x+1][y])
            view(x+1,y,grid,hasviewed);
        if (y+1<grid[0].length&&grid[x][y+1]=='1'&&!hasviewed[x][y+1])
            view(x,y+1,grid,hasviewed);
        if (x>0&&grid[x-1][y]=='1'&&!hasviewed[x-1][y])
            view(x-1,y,grid,hasviewed);
        if (y>0&&grid[x][y-1]=='1'&&!hasviewed[x][y-1])
            view(x,y-1,grid,hasviewed);
    }
    public int numIslands(char[][] grid) {
        if (grid.length==0||grid[0].length==0)
            return 0;
        int res=0;
        boolean[][] hasviewed=new boolean[grid.length][grid[0].length];
        for (int x=0;x<grid.length;x++){
            for (int y=0;y<grid[0].length;y++){
                if (!hasviewed[x][y]&&grid[x][y]=='1'){
                    res++;
                    view(x,y,grid,hasviewed);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Leetcode200 lc=new Leetcode200();
        char[][] grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(lc.numIslands(grid));
    }
}
