import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode279 {
    // 第一个用的深搜然后慢了
//    int realres=Integer.MAX_VALUE;
//    public void count(int n,int[] pows,int endpos,int nowcount){
//        if (n==0){
//            realres=Math.min(nowcount,realres);
//            return;
//        }
//        if (nowcount>realres)
//            return;
//        int res=Integer.MAX_VALUE;
//        for (int pos=endpos-1;pos>=0;pos--){
//            int tmp=n/pows[pos];
//            count(n%pows[pos],pows,pos,nowcount+tmp);
//            if (tmp<res)
//                res=tmp;
//        }
//    }
//    public int numSquares(int n) {
//        if (n==0)
//            return 1;
//        int lens=(int)Math.sqrt(n);
//        int[] pows=new int[lens];
//        for (int pos=0;pos<lens;pos++)
//            pows[pos]=(pos+1)*(pos+1);
//        count(n,pows,lens,0);
//        return realres;
//    }

    public int count(List<Integer> nowcount,int floor,int[] pows){
        List<Integer> next=new ArrayList<>();
        for (int num:nowcount){
            for (int pow:pows){
                if (pow==num)
                    return floor;
                if (pow<num)
                    next.add(num-pow);
                else
                    break;
            }
        }
        return count(next,floor+1,pows);
    }
        public int numSquares(int n) {
            if (n==0)
                return 1;
            int lens=(int)Math.sqrt(n);
            int[] pows=new int[lens];
            for (int pos=0;pos<lens;pos++)
                pows[pos]=(pos+1)*(pos+1);
            List<Integer> mylist=new ArrayList<Integer>();
            mylist.add(n);
            return count(mylist,1,pows);
        }

    public static void main(String[] args){
        Leetcode279 lc=new Leetcode279();
        lc.numSquares(487);
    }
}
