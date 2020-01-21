import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {
    // 答案似乎挺喜欢使用stringbuilder的
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<String>();
        int begin=0;
        int nowlen=0;
        for (int pos=0;pos<words.length;pos++){
            int tmplen=words[pos].length();
            if (nowlen+tmplen+pos==maxWidth+begin){
                String onestr=new String("");
                for (int i=begin;i<=pos;i++){
                    onestr+=words[i];
                    if (i!=pos)
                        onestr+=" ";
                }
                res.add(onestr);
                begin=pos+1;
                nowlen=0;
                continue;
            }else if (nowlen+tmplen+pos>maxWidth+begin){
                String onestr=new String("");
                // 空格段落数量
                int spces=pos-begin-1;
                // 空格总数量
                int spacenum=maxWidth-nowlen;
                int eachs=spacenum;
                // 当只有一个单词的时候
                if (spces!=0){
                    eachs/=spces;
                    spacenum%=spces;
                }else
                    spacenum=0;
                // 最左侧的空格个数
                for (int i=begin;i<pos;i++){
                    onestr+=words[i];
                    int mysapce=eachs;
                    while (mysapce>0&&(i!=pos-1||i==begin)){
                        onestr+=" ";
                        mysapce--;
                    }
                    // 添加空格,这个肯定不是最后一个
                    if (spacenum>0){
                        onestr+=" ";
                        spacenum--;
                    }
                }
                res.add(onestr);
                begin=pos;
                nowlen=tmplen;
            }else{
                nowlen+=tmplen;
                if (pos!=words.length-1)
                    continue;
            }
            if (pos==words.length-1){
                String onestr=new String("");
                for (int i=begin;i<=pos;i++){
                    onestr+=words[i];
                    if (nowlen<maxWidth)
                        onestr+=" ";
                    nowlen++;
                }
                while (nowlen<maxWidth){
                    onestr+=" ";
                    nowlen++;
                }
                res.add(onestr);
            }
        }
        return res;
    }
}
