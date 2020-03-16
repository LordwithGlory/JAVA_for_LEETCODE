public class Leetcode171 {
    public int titleToNumber(String s) {
        int lems=s.length();
        if (lems==0)
            return 0;
        int base=1;
        int res=0;
        for (int pos=lems-1;pos>=0;pos--) {
            int tmp = s.charAt(pos) - 'A'+1;
            res += tmp * base;
            base *= 26;
        }
        return res;
    }

}
