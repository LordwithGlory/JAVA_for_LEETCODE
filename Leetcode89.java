import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        // 最快的那个使用镜像方法厉害啊
        // 根本不需要使用字符串的转换
//        res.add(0);
//        int gap = 1;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = res.size() - 1; j >= 0; j--) {
//                res.add(res.get(j) + gap);
//            }
//            gap *= 2;
//        }
        List<Integer> res=new ArrayList<Integer>();
        res.add(0);
        if (n==0){
            return res;
        }
        String onestr=new String("");
        for (int i=0;i<n;i++){
            onestr+="0";
        }
        StringBuilder strbd=new StringBuilder(onestr);
        double len=Math.pow(2,n);
        for (int i=1;i<len;i++){
            if (i%2==1){
                if (strbd.charAt(n-1)=='0')
                    strbd.setCharAt(n-1,'1');
                else {
                    strbd.setCharAt(n-1,'0');
                }
            }else {
                int first=n-1;
                while (strbd.charAt(first)=='0')
                    first--;
                first--;
                if (strbd.charAt(first)=='0')
                    strbd.setCharAt(first,'1');
                else
                    strbd.setCharAt(first,'0');
            }
            res.add(Integer.parseInt(strbd.toString(),2));
        }
        return res;
    }
    public static void main(String[] args){
        Leetcode89 lc=new Leetcode89();
        System.out.println(lc.grayCode(2));
    }
}
