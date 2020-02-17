import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    // 速度快的那个长度合规判断是在父函数里面而不是子函数里面
    public void findIP(String s,int inter,List<String> res,String list){
        int len=s.length();
        if (len<inter||len>inter*3)
            return;
        // 表示是最后一段ip
        if (inter==1){
            if (len!=1&&s.charAt(0)=='0')
                return;
            int tmp=Integer.valueOf(s);
            if (tmp<256){
                list+=s;
                res.add(new String(list));
                return;
            }
        }
        for (int i=1;i<=3&&i<len;i++){
            int tmp=Integer.valueOf(s.substring(0,i));
            if (tmp<256){
                findIP(s.substring(i,len),inter-1,res,list+s.substring(i,len)+'.');
                if (i==1 && tmp==0){
                    break;
                }
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        findIP(s,4,res,"");
        return res;
    }

    public static void main(String[] args){
        String s=new String("25525511135");
        Leetcode93 lc=new Leetcode93();
        System.out.println(lc.restoreIpAddresses(s));
    }
}
