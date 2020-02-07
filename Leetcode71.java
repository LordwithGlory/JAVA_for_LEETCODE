import java.util.Stack;

public class Leetcode71 {
    public String simplifyPath(String path) {
        String res=new String("/");
        Stack<String> thest=new Stack<String>();
        int strlen=path.length();
        int nowpos=0;
        while (nowpos<strlen&&path.charAt(nowpos)=='/')
            nowpos++;
        for (;nowpos<strlen;){
            int beginpos=nowpos;
            while (nowpos<strlen&&path.charAt(nowpos)!='/')
                nowpos++;
            String nowstr=path.substring(beginpos,nowpos);
            if (nowstr.equals("..")){
                if (!thest.empty())
                    thest.pop();
            }else if (!nowstr.equals(".")) {
                thest.push(nowstr);
            }
            while (nowpos<strlen&&path.charAt(nowpos)=='/'){
                nowpos++;
            }
        }
        int thestnum=thest.size();
        for (int i=0;i<thestnum;i++){
            res+=thest.elementAt(i);
            if (i!=thestnum-1)
                res+='/';
        }
        return res;
    }
}
