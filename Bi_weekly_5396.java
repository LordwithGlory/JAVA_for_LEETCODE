public class Bi_weekly_5396 {
    public int maxPower(String s) {
        int res=1;
        int beginpos=0;
        char thechar=s.charAt(0);
        for (int pos=1;pos<s.length();pos++){
            if (s.charAt(pos)==thechar)
                continue;
            thechar=s.charAt(pos);
            res=Math.max(res,pos-beginpos);
            beginpos=pos;
        }
        res=Math.max(res,s.length()-beginpos);
        return res;
    }
}
