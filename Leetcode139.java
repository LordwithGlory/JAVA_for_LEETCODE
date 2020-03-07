import java.util.List;

public class Leetcode139 {
    // 最快的那个是使用了s.indexOf(word, index)函数
    public void judge(int start,int[] res,char[] mystr,List<String> wordDict){
        if (res[start]!=0)
            return;
        String tmpstr="";
        for (int pos=start;pos<mystr.length;pos++){
            tmpstr+=mystr[pos];
            if (wordDict.contains(tmpstr)){
                if (pos==mystr.length-1){
                    res[start]=1;
                    return;
                }
                judge(pos+1,res,mystr,wordDict);
                if (res[pos+1]==1){
                    res[start]=1;
                    return;
                }
            }
        }
        res[start]=-1;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null||s.length()==0)
            return false;
        int[] theres=new int[s.length()];
        char[] mystr=s.toCharArray();
        judge(0,theres,mystr,wordDict);
        if (theres[0]>0)
            return true;
        return false;
    }
}
