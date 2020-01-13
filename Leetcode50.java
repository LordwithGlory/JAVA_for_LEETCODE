public class Leetcode50 {
    public double myPow(double x, int n) {
        double res=1;
        if (n==0)
            return res;
        res=myPow(x,n/2);
        res*=res;
        if (n%2==1)
            res*=x;
        if (n%2==-1)
            res*=1/x;
        return res;
    }
}
