import java.util.*;

public class Bi_weekly_5373 {
//    public int findmin(int k,Map<Integer,Integer> mymap){
//        if (mymap.containsKey(k))
//            return mymap.get(k);
//        int res=k;
//        for (Integer minnum:mymap.keySet()){
//            if (minnum==1)
//                continue;
//            if (minnum>k)
//                break;
//            // 由于线程安全所以报错了
//            res=Math.min(findmin(k-minnum,mymap)+1,res);
//        }
//        mymap.put(k,res);
//        return res;
//    }
//    public int findmin(int k,Map<Integer,Integer> mymap,Set<Integer> fobo){
//        if (fobo.contains(k))
//            return 1;
//        if (mymap.containsKey(k))
//            return mymap.get(k);
//        int res=k;
//        for (int min:fobo){
//            if (min>k/2)
//                break;
//            res=Math.min(1+findmin(k-min,mymap,fobo),res);
//            if (res==2)
//                break;
//        }
//        mymap.put(k,res);
//        return res;
//    }
    public int findMinFibonacciNumbers(int k) {
        int lower=1;
        int highr=1;
        if (k==1)
            return 1;
        // 最大的问题居然是setfobo不是按照顺序的。。。
//        Set<Integer> fobo=new HashSet<>();
        List<Integer> fobo=new ArrayList<>();
        Set<Integer> hasfound=new HashSet<>();
        fobo.add(1);
        while (highr<=k){
            int tmp=highr+lower;
            lower=highr;
            highr=tmp;
            fobo.add(highr);
        }
        List<Integer> needmin=new ArrayList<>();
        needmin.add(k);
        int res=1;
        while (!needmin.isEmpty()){
            int len=needmin.size();
            while (len>0){
                len--;
                int next=needmin.remove(0);
                for (int nop:fobo){
                    int num=next-nop;
                    if (nop>next)
                        break;
                    if (hasfound.contains(num))
                        continue;
                    if (num==0)
                        return res;
                    hasfound.add(num);
                    needmin.add(num);
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args){
        Bi_weekly_5373 bw=new Bi_weekly_5373();
        System.out.println(bw.findMinFibonacciNumbers(13));
    }
}
