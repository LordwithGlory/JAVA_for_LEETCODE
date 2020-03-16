import java.util.HashMap;
import java.util.Map;

public class Leetcode172 {
    public static void main(String[] args){
        Leetcode172 lc=new Leetcode172();
        lc.trailingZeroes(1808548329);
    }
    public int trailingZeroes(int n) {
        // 下面这个是最快的好像的确是哦
//        do{
//            n=n/5;
//            res += n;
//        }
//        while(n>=5);
        int res=0;
        if (n<5)
            return 0;
        Map<Integer,Integer> contains_five=new HashMap<>();
        int old=0;
        int num=5;
        for (;num<=n;){
            old=old*5+1;
            contains_five.put(num,old);
            if (num>Integer.MAX_VALUE/5)
                break;
            num*=5;
        }
        if (num>n)
            num/=5;
        while (num>4){
            res+=contains_five.get(num)*(n/num);
            n%=num;
            num/=5;
        }
        return res;
//        int res=0;
//        Map<Integer,Integer> contains_five=new HashMap<>();
//        for (int pos=1;pos<=n;pos++){
//            if (pos%5!=0)
//                continue;
//            int tmp=pos;
//            int con_five=0;
//            while (tmp!=0&&tmp%5==0){
//                if (contains_five.containsKey(tmp)){
//                    con_five+=contains_five.get(tmp);
//                    break;
//                }
//                tmp/=5;
//                con_five++;
//            }
//            contains_five.put(pos,con_five);
//            res+=con_five;
//        }
//        return res;
    }
}
