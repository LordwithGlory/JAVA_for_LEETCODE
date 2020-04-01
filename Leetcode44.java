import java.util.HashSet;
import java.util.Set;

public class Leetcode44 {
    Set<String> errorset=new HashSet<>();
    public boolean isMatch(String s, String p) {
        if (errorset.contains(s+" "+p))
            return false;
        if (s.length()==0&&p.length()==0)
            return true;
        if (p.length()==0)
            return false;
        if (s.length()==0){
            int pos=0;
            while (pos<p.length()&&p.charAt(pos)=='*')
                pos++;
            if (pos==p.length())
                return true;
            return false;
        }
        if (s.charAt(0)==p.charAt(0)||p.charAt(0)=='?'){
            if (isMatch(s.substring(1),p.substring(1)))
                return true;
            errorset.add(s+" "+p);
            return false;
        }
        if (p.charAt(0)=='*'){
            if (isMatch(s,p.substring(1))||isMatch(s.substring(1),p))
                return true;
            errorset.add(s+" "+p);
            return false;
        }
        return false;
    }

    public boolean macth_word(String s,String p){
        if (s.length()==0&&p.length()==0)
            return true;
        else if (p.length()==0)
            return false;
        else if (s.length()==0){
            boolean res=true;
            for (int pos=0;pos<p.length()&&res;pos++){
                if (p.charAt(pos)!='*')
                    res=false;
            }
            return res;
        }
        boolean[][] res=new boolean[s.length()+1][p.length()+1];
        int pos=0;
        int spos=0;
        res[0][0]=true;
        for (pos=1;pos<=p.length();pos++)
            res[0][pos]=res[0][pos-1]&&p.charAt(pos-1)=='*';
        for (pos=1;pos<=p.length();pos++){
            for (spos=1;spos<=s.length();spos++){
                if (s.charAt(spos-1)==p.charAt(pos-1)||p.charAt(pos-1)=='?')
                    res[spos][pos]=res[spos-1][pos-1];
                else if (p.charAt(pos-1)=='*')
                    res[spos][pos]=res[spos][pos-1]||res[spos-1][pos];
            }
        }
        return res[s.length()][p.length()];
    }


    public static void main(String[] args){
        String s="aa";
        String p="*";
        Leetcode44 lc=new Leetcode44();
        System.out.println(lc.isMatch(s,p));
    }
}
