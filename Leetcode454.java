import java.util.HashMap;
import java.util.Map;

public class Leetcode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 最快的居然自定义了Map.compute()
        if (A.length==0)
            return 0;
        Map<Integer,Integer> mycount=new HashMap<>();
        int res=0;
        for (int num:A){
            for (int count:B){
                int next=num+count;
                mycount.put(next,1+mycount.getOrDefault(next,0));
            }
        }
        for (int num:C){
            for (int count:D){
                int next=-num-count;
                res+=mycount.getOrDefault(next,0);
            }
        }
        return res;
        // 正挺好不过就是超时
//        Map<Integer,Integer> mycout=null;
//        Map<Integer,Integer> nextcount=new HashMap<>();
//        int[][] theres=new int[4][];
//        theres[0]=A;
//        theres[1]=B;
//        theres[2]=C;
//        theres[3]=D;
//        nextcount.put(0,1);
//        for (int pos=0;pos<4;pos++){
//            mycout=nextcount;
//            nextcount=new HashMap<>();
//            for (int num:theres[pos]){
//                for (int mykey:mycout.keySet()){
//                    int next=mykey+num;
//                    nextcount.put(next,nextcount.getOrDefault(next,0)+mycout.get(mykey));
//                }
//            }
//        }
//        return nextcount.getOrDefault(0,0);
    }

    public static void main(String[] args){
        int[] a={1,2};
        int[] b={-2,-1};
        int[] c={-1,2};
        int[] d={0,2};
        Leetcode454 lc=new Leetcode454();
        lc.fourSumCount(a,b,c,d);
    }
}
