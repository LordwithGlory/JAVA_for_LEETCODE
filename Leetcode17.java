import java.util.ArrayList;
import java.util.List;

// 整个List真鸡儿难
// for each用法，substring用法
// Java插入字符串：https://blog.csdn.net/luojun_/article/details/79240361
// Java 字符串替换等：https://www.cnblogs.com/freeabyss/archive/2013/05/15/3187057.html
public class Leetcode17 {
    private  List<String>findlists(String digits,int dlen,int pos,String[] strs){
        int tempint=digits.charAt(pos)-'0';
        List<String> nowstr=new ArrayList<String>();
        if(pos==dlen)
            return nowstr;
        if(tempint>9||tempint<2)
            return findlists(digits,dlen,pos+1,strs);
        List<String> nextstr=new ArrayList<String>();
        if(pos<dlen-1){
            nextstr=findlists(digits,dlen,pos+1,strs);
        }
        int llen=nextstr.size();
        int strsmax=3;
        if(tempint==7||tempint==9)
            strsmax=4;
        for(int i=0;i<strsmax;i++){
            String onechar=strs[tempint].substring(i,i+1);
            if(nextstr.size()!=0){
                for(String nexts : nextstr){
                    String addone=onechar+nexts;
                    if(nowstr.contains(addone))
                        continue;
                    nowstr.add(addone);
                }
            }else {
                nowstr.add(onechar);
            }
        }
        return  nowstr;
    }
    public List<String>letterCombinations(String digits) {
         List<String>backres=new ArrayList<String>();
         if(digits.length()==0)
             return  backres;
        String[] strs={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int len=digits.length();
        //把每个都进行计算了长度
        backres=findlists(digits,len,0,strs);
        return  backres;
    }

    public static void main(String[] args){
        Leetcode17 solution=new Leetcode17();
        String input=new String("23297");
        System.out.println(solution.letterCombinations(input));
    }
}
