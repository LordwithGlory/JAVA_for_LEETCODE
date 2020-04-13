public class Leetcode52 {
    public int getfloor(int nowfloor,int[] row_num,boolean[] col_nums,int n){
        if (nowfloor==n)
            return 1;
        int res=0;
        for (int num=0;num<n;num++){
            if (col_nums[num])
                continue;
            col_nums[num]=true;
            for (int former=0;former<nowfloor;former++){
                if (nowfloor-former==Math.abs(num-row_num[former])){
                    col_nums[num]=false;
                    break;
                }
            }
            if (col_nums[num]){
                row_num[nowfloor]=num;
                res+=getfloor(nowfloor+1,row_num,col_nums,n);
                col_nums[num]=false;
            }
        }
        return res;
    }
    public int totalNQueens(int n) {
        if (n==0)
            return 0;
        boolean[] col_nums=new boolean[n];
        int[] row_num=new int[n];
        return getfloor(0,row_num,col_nums,n);
    }
}
