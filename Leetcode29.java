import javax.print.DocFlavor;

public class Leetcode29 {
    public int divide(int dividend, int divisor) {
        // 最快的那群🐶使用的是移位和long long
        // md真的是🐶 而且这个题目我特娘的还见过
        // 忽然想到当年等6室之旅
        int res=0;
        boolean posd,posr;
        posd=posr=true;
        if(dividend<0)
            posd=false;
        if (divisor<0)
            posr=false;
        if(Math.abs(divisor)==1){
            // 这个目测已经包含了所有特殊情况
            if(dividend==Integer.MIN_VALUE&&divisor==-1){
                return Integer.MAX_VALUE;
            }
            if(divisor==1){
                return dividend;
            }else {
                return 0-dividend;
            }
        }else if(divisor==Integer.MIN_VALUE){
            // md没想到还可以作为除数
            if(dividend==divisor){
                return 1;
            }else {
                return 0;
            }
        }
        if(posd^posr){
            while (Math.abs(dividend)>=Math.abs(divisor)||dividend==Integer.MIN_VALUE){
                // 如果结果的确是MIN_VALUE，判断部分放在后面会出问题
//                if(res==Integer.MIN_VALUE){
//                    return Integer.MAX_VALUE;
//                }
                res--;
                dividend+=divisor;
            }
        }else{
            // 最小数字等abs应该等于0就会报错
            while (Math.abs(dividend)>=Math.abs(divisor)||dividend==Integer.MIN_VALUE){
                res++;
                dividend-=divisor;
//                if(res==Integer.MIN_VALUE){
//                    return Integer.MAX_VALUE;
//                }
            }
        }
        return res;
    }
}
