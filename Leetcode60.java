public class Leetcode60 {
    public String getPermutation(int n, int k) {
        // 看简短的代码直接使用list获取
        // 他把k减去1然后不用考虑我的特殊情况
        int[] ntan=new int[10];
        boolean[] coun=new boolean[10];
        String res=new String("");
        ntan[0]=1;
        for (int i=1;i<10;i++){
            ntan[i]=i*ntan[i-1];
        }
        if (n==0)
            return "0";
        int maxnum=n;
        if (k==ntan[maxnum]){
            for (int i=n;i>=1;i--){
                res+=Integer.toString(i);
            }
            return res;
        }
        while (k>0){
            // 因为都是向下取所以要num加一，保证0的时候他也可以完成
            int num=k/ntan[maxnum-1]+1;
            // 如果是余数为0，那么刚才的加一就没有必要了
            if (k%ntan[maxnum-1]==0)
                num--;
            for (int i=1;i<=n;i++){
                if (coun[i])
                    continue;
                // 找到第一个位置数字
                // 该数字应该是从小往大第num个
                num--;
                if (num!=0)
                    continue;
                res+=Integer.toString(i);
                coun[i]=true;
                break;
            }
            if (k%ntan[maxnum-1]==0){
                // 既然确定了第一个数字后面的数字就可以确定了
                // 由于是一个阶乘所以从大往小就行了
                for (int i=n;i>0;i--){
                    if (coun[i])
                        continue;
                    res+=Integer.toString(i);
                    coun[i]=true;
                }
                return res;
            }
            k%=ntan[maxnum-1];
            maxnum--;
        }
        return res;
    }
}
