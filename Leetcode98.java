import java.util.HashMap;
import java.util.Map;

public class Leetcode98 {
    // 其实是97
    Map<String,String> mymsp=new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        // 最快的那个狗果然用的是二维数组存的DP
        int len1=s1.length();
        int len2=s2.length();
        int lens=s3.length();
        if (len1+len2!=lens)
            return false;
        if (len1==0){
            if (s2.equals(s3))
                return true;
            else
                return false;
        }
        if (mymsp.containsKey(s1+s2)){
            if (s1.equals(mymsp.get(s1+s2)))
                return false;
        }
        if (len2==0){
            if (s1.equals(s3))
                return true;
            else
                return false;
        }
        if (s1.charAt(0)==s3.charAt(0)&&isInterleave(s1.substring(1,len1),s2,s3.substring(1,lens)))
            return true;
        if (s2.charAt(0)==s3.charAt(0)&&isInterleave(s1,s2.substring(1,len2),s3.substring(1,lens)))
            return true;
        mymsp.put(s1+s2,s1);
        return false;
    }
    public static void main(String[] args){
        String s1=new String("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa");
        String s2=new String("babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab");
        String s3="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        Leetcode98 lc=new Leetcode98();
        System.out.println(lc.isInterleave(s1,s2,s3));
    }
}
