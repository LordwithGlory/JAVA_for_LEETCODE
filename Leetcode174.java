public class Leetcode174 {
    public int calculateMin(int[][]dungeon,boolean[][]has_viwed,int row,int col,int[][] needsteps){
        if (has_viwed[row][col])
            return needsteps[row][col];
        if (row==dungeon.length-1&&col==dungeon[0].length-1){
            has_viwed[row][col]=true;
            if (dungeon[row][col]<=0){
                needsteps[row][col]=Math.abs(dungeon[row][col])+1;
            }else
                needsteps[row][col]=1;
            return needsteps[row][col];
        }
        int need=Integer.MAX_VALUE;
        if (row+1<dungeon.length)
            need=Math.min(need,calculateMin(dungeon,has_viwed,row+1,col,needsteps));
        if (col+1<dungeon[0].length)
            need=Math.min(need,calculateMin(dungeon,has_viwed,row,col+1,needsteps));
        if (dungeon[row][col]>=need)
            need=1;
        else
            need-=dungeon[row][col];
        has_viwed[row][col]=true;
        needsteps[row][col]=need;
        return needsteps[row][col];
    }
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length==0||dungeon[0].length==0)
            return 0;
        int row=dungeon.length;
        int col=dungeon[0].length;
        int[][] need_steps=new int[row][col];
        boolean[][] has_viewed=new boolean[row][col];
        return calculateMin(dungeon,has_viewed,0,0,need_steps);
    }

    public static void main(String[] args){
        Leetcode174 lc=new Leetcode174();
        int[][] dungon={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        lc.calculateMinimumHP(dungon);
    }
}
