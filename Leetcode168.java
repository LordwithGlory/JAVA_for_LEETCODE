public class Leetcode168 {
    public String convertToTitle(int n) {
        if (n==0)
            return null;
        String[] myres={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String res=new String("");
        while (n>0){
            n--;
            res=myres[n%26]+res;
            n-=n%26;
            n/=26;
        }
        return res;
    }

    public static void main(String[] args){
        Leetcode168 lc=new Leetcode168();
        System.out.println(lc.convertToTitle(28));
    }
}
