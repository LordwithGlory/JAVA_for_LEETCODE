public class Leetcode135 {
    public int candy(int[] ratings) {
        // 最快的贪心是先把开始变大的加一，否则设置为1
        // 之后逆向进行处理
        int[] lcandy=new int[ratings.length];
        int[] rcandy=new int[ratings.length];
        int res=0;
        lcandy[0]=1;
        for (int pos=1;pos<ratings.length;pos++){
            if (ratings[pos]<=ratings[pos-1])
                lcandy[pos]=1;
            else
                lcandy[pos]=lcandy[pos-1]+1;
        }
        rcandy[ratings.length-1]=1;
        res+=lcandy[ratings.length-1];
        for (int pos=ratings.length-2;pos>=0;pos--){
            if (ratings[pos]<=ratings[pos+1])
                rcandy[pos]=1;
            else
                rcandy[pos]=rcandy[pos+1]+1;
            res+=Math.max(lcandy[pos],rcandy[pos]);
        }
        return res;
    }
}
