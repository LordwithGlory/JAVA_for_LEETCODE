import java.util.Vector;

public class Leetcode43 {
    // 更快的方法是先转换为数组然后再通过数组进行操作
    public String addstr(String num1,String num2){
        // 字符串处理：https://www.cnblogs.com/oumyye/p/4227228.html
        int len1=num1.length()-1;
        int len2=num2.length()-1;
        String res=new String("");
        boolean addflag=false;
        while (len1>=0||len2>=0){
            int nownum=0;
            if (addflag)
                nownum=1;
            addflag=false;
            if (len1>=0)
                nownum+=num1.charAt(len1--)-'0';
            if (len2>=0)
                nownum+=num2.charAt(len2--)-'0';
            if (nownum>=10){
                addflag=true;
                nownum%=10;
            }
            // 字符串数字转换：https://blog.csdn.net/wo_shi_LTB/article/details/78802921
            res=String.valueOf(nownum)+res;
        }
        if (addflag)
            res="1"+res;
        return res;
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0"))
            return "0";
        String res=new String("");
        String[] muti=new String[10];
        muti[0]="0";
        muti[1]=num1;
        for (int i=2;i<10;i++){
            muti[i]=addstr(num1,muti[i-1]);
        }
        for (int i=0;i<num2.length();i++){
            if (i!=0)
                res+="0";
            char now=num2.charAt(i);
            if (now=='0')
                continue;
            int move=now-'0';
            res=addstr(res,muti[move]);
        }
        return res;
    }
    public static void main(String[] args){
        Leetcode43 lc=new Leetcode43();
        System.out.println(lc.multiply("9","9"));
    }
}
