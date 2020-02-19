public class Leetcode96 {
//    int[] res=new int[100];
    public int numTrees(int n) {
        int[] res=new int[n+1];
        res[0]=0;
        res[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                if (j==1)
                    res[i]+=res[i-1];
                else if (j==i)
                    res[i]+=res[i-1];
                else {
                    res[i]+=res[j-1]*res[i-j];
                }
            }
        }
        return res[n];
//        if (n==0)
//            return 0;
//        if (n==1)
//            return 1;
//        for (int i=1;i<=n;i++){
//            if (res[i-1]==0){
//                res[i-1]=numTrees(i-1);
//            }
//            if (res[n-i]==0){
//                res[n-i]=numTrees(n-i);
//            }
//            if (n==i || i==1){
//                res[n]+=res[n-1];
//            }else {
//                res[n]+=res[i]*res[n-i];
//            }
//        }
//        return res[n];
    }

    public static void main(String[] args){
        Leetcode96 lc=new Leetcode96();
        System.out.println(lc.numTrees(3));
    }
}
