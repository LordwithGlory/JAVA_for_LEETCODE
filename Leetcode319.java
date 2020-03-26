public class Leetcode319 {
    public int bulbSwitch(int n) {
        // 论找规律的重要性emmm已经是最快了
        // 还有个操作是直接开方==
        if (n<2)
            return n;
        int res=0;
        int base=0;
        for (int pos=0;pos<=n;pos+=base+1){
            res++;
            base+=2;
        }
        return res;
        // 果然是个超时狗==
//        boolean[] bulbs=new boolean[n];
//        for (int round=2;round<=n;round++){
//            for (int pos=round-1;pos<n;pos+=round)
//                bulbs[pos]=!bulbs[pos];
//        }
//        int res=0;
//        for (boolean bulb:bulbs){
//            if (!bulb)
//                res++;
//        }
//        return res;
    }
}
