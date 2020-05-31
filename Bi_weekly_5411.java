public class Bi_weekly_5411 {
    private int cherry(int floor,int[][] gird,int[] robot,int rowlen,int collen,int[][][] steps){
        if (floor==rowlen)
            return 0;
        int[][] nextrow=new int[2][3];
        for (int r=0;r<2;r++){
            for (int pos=0;pos<3;pos++)
                nextrow[r][pos]=robot[r]+pos-1;
        }
        int theres=gird[floor][robot[0]]+gird[floor][robot[1]];
        if (robot[0]==robot[1])
            theres/=2;
        int res=0;
        for (int one=0;one<3;one++){
            if (nextrow[0][one]<0||nextrow[0][one]>=collen)
                continue;
            int[] tmp=new int[2];
            tmp[0]=nextrow[0][one];
            for (int two=0;two<3;two++){
                if (nextrow[1][two]<0||nextrow[1][two]>=collen)
                    continue;
                tmp[1]=nextrow[1][two];
                if (steps[floor][tmp[0]][tmp[1]] == 0)
                    steps[floor][tmp[0]][tmp[1]]=steps[floor][tmp[1]][tmp[0]]=cherry(floor+1,gird,tmp,rowlen,collen,steps);
                res=Math.max(steps[floor][tmp[0]][tmp[1]],res);
            }
        }
        theres+=res;
        return theres;
    }
    public int cherryPickup(int[][] grid) {
        int rowlen=grid.length;
        int collen=grid[0].length;
        int[] nowpos=new int[2];
        int[][][] steps=new int[rowlen][collen][collen];
        nowpos[0]=0;
        nowpos[1]=collen-1;
        return cherry(0,grid,nowpos,rowlen,collen,steps);
    }
}
