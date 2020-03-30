public class Leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        int tlen=T.length;
        int[] res=new int[tlen];
        for (int pos=tlen-1;pos>=0;pos--){
            int nowtemp=T[pos];
            int nowpos;
            for (nowpos=pos+1;nowpos<tlen;nowpos++){
                while (T[nowpos]<=nowtemp&&res[nowpos]!=0)
                    nowpos+=res[nowpos];
                if (T[nowpos]>nowtemp){
                    res[pos]=nowpos-pos;
                    break;
                }else if (res[nowpos]==0){
                    // 加了这个判断就速度成为0.1%
                    res[pos]=0;
                    break;
                }
            }
            if (nowpos==tlen)
                res[pos]=0;
        }
        return res;
    }
}
