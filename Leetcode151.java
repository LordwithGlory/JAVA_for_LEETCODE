import java.util.ArrayList;
import java.util.List;

public class Leetcode151 {
    public String reverseWords(String s) {
        s=s.strip();
        int lens=s.length();
        if (lens==0)
            return s;
        String res="";
        String[] myres=s.split(" ");
        // int pos遍历比foreach遍历更快
        for (String one:myres){
            if (one.equals(""))
                continue;
            if (res!="")
                res=" "+res;
            res=one+res;
        }
        return res;
//        char former=s.charAt(0);
//        res+=former;
//        for (int pos=1;pos<lens;pos++){
//            if (former==' '&&s.charAt(pos)==' ')
//                continue;
//            former=s.charAt(pos);
//            res=former+res;
//        }
//        return res;
    }
    public static void main(String[] args){
        Leetcode151 lc=new Leetcode151();
        String s="hello     world";
        System.out.println(lc.reverseWords(s));
    }
}
