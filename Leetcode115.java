import java.util.HashMap;
import java.util.Map;

public class Leetcode115 {
    // 快的那个用的二维数组来做的
    Map<String,Integer> mycout=new HashMap<>();
    public int numDistinct(String s, String t) {
        String thekey=s+" "+t;
        if (mycout.containsKey(thekey))
            return mycout.get(thekey);
        if (s.length()<t.length())
            return 0;
        else if (s.equals(t))
            return 1;
        else if (t.length()==0)
            return 0;
        int res=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==t.charAt(0)){
                if (t.length()==1){
                    res+=1;
                    continue;
                }
                res+=numDistinct(s.substring(i+1,s.length()),t.substring(1,t.length()));
            }
        }
        mycout.put(thekey,res);
        return res;
    }

    public static void main(String[] args){
        String s="babgbag";
        String t="bag";
        Leetcode115 lc=new Leetcode115();
        System.out.println(lc.numDistinct(s,t));
    }
}
