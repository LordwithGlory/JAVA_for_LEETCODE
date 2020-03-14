import java.util.ArrayList;
import java.util.List;

public class Leetcode166 {
    public String fractionToDecimal(int numerator, int denominator) {
        // 用int的话res的确会爆掉==可太蓝了
        // 最快的是全部设置为了long类型
        List<Long> myint=new ArrayList<>();
        String res=new String("");
        boolean isnavie=false;
        long ntor=(long)numerator;
        if (numerator<0&&denominator>0||numerator>0&&denominator<0){
            ntor=-numerator;
            isnavie=true;
        }
        boolean iscycle=false;
        long cyclenum=0;
        Long nowres=ntor/denominator;
        if (nowres*denominator==numerator)
            return Long.toString(nowres);
        while (ntor!=0){
            nowres=ntor/denominator;
            if (!res.equals("")){
                if (myint.contains(ntor)){
                    iscycle=true;
                    cyclenum=ntor;
                    break;
                }
                res+=Long.toString(nowres);
                myint.add(ntor);
            }else {
                res+=Long.toString(nowres);
                res+=".";
            }
            ntor=ntor-(long)nowres*denominator;
            ntor*=10;
        }
        if (iscycle){
            int thepos=myint.indexOf(cyclenum);
            int pointpos=res.indexOf(".");
            thepos+=pointpos+1;
            res=res.substring(0,thepos)+"("+res.substring(thepos)+")";
        }
        if (isnavie)
            res="-"+res;
        return res;
    }

    public static void main(String[] args){
        Leetcode166 lc=new Leetcode166();
        System.out.println(lc.fractionToDecimal(-1,-2147483648));
    }
}
