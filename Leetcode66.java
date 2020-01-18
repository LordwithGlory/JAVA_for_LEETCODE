public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        int lens=digits.length;
        boolean needadd=false;
        for (int i=lens-1;i>=0;i--){
            if (i==lens-1){
                digits[i]+=1;
            }
            if (needadd)
                digits[i]+=1;
            needadd=false;
            if (digits[i]>9){
                digits[i]%=10;
                needadd=true;
            }
        }
        if (!needadd)
            return digits;
        int[] res=new int[lens+1];
        res[0]=1;
        for (int i=0;i<lens;i++)
            res[i+1]=digits[i];
        return res;
    }
}
