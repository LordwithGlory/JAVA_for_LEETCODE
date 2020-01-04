import java.util.*;

public class Leetcode30 {
    public boolean juedgeIsRight(String s,int len,Map<String,Integer> counter){
        boolean res=true;
        int pos=0;
        for (;pos<s.length()&&res;){
            String son=s.substring(pos,pos+len);
            if (counter.containsKey(son)){
                int strcon=counter.get(son);
                strcon--;
                counter.replace(son,strcon);
            }else {
                res=false;
            }
            pos+=len;
        }
        if (res){
            for (int v:counter.values()){
                if (v!=0){
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
    public List<Integer> findSubstr(String s, String[] words){
        List<Integer> res=new ArrayList<Integer>();
        if (s==null||words==null||s.length()==0||words.length==0){
            return res;
        }
        // 把原油字符串分开
        String[] sons=new String[100];
        String son=new String();
        // 单个字符串的长度
        int wordlen=words[0].length();
        int pos=0;
        // 包含多少个字符串
        int lens=words.length;
        Queue<String> tmpstrs=new LinkedList<String>();
        // 用来标记queue中指定字符串的多少
        int targetnum=0;
        if (s.length()<wordlen*lens){
            return res;
        }
        // 对于数量进行统计
        Map<String,Integer> strCounter=new HashMap<String, Integer>();
        for (String word:words){
            if (strCounter.containsKey(word)){
                int counter=strCounter.get(word);
                strCounter.replace(word,counter+1);
            }else {
                strCounter.put(word,1);
            }
        }
        // 对于原有字符串进行分割
        // 边分割边判断
        int maxlen=s.length()-lens*wordlen;
        // 这边还需要一个等号
        // 最快的那个根据wordlen分组，然后每组里面按照wordlen*lens这个长度进行判断，
        // 不过判断时候是每个长度从后往前速度很高
        for (;pos<=maxlen;pos++){
            // 属于深拷贝，不使用一块内存的
            Map<String,Integer> tmpmap=new HashMap<String, Integer>();
            tmpmap.putAll(strCounter);
            if (juedgeIsRight(s.substring(pos,pos+wordlen*lens),wordlen,tmpmap)){
                res.add(pos);
            }
        }
        return res;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        String[] sons = new String[30];
        int lens=words[0].length();
        int pos=0;
        int wordsnum=words.length;
        // 表示现在已经发现有多少个字符串出现
        int nowcounter=0;
        // 将现有的字符串按照长度进行分割
        for(;pos<s.length();){
            sons[pos/lens]=s.substring(pos,pos+lens);
            pos+=lens;
        }
        // 写string和int的映射，主要是表现他上次出现的位置
        Map<String,Integer> str2int= new HashMap<String, Integer>();
        for(String word:words){
            str2int.put(word,-1);
        }
        pos=0;
        for(String now:sons){
            if (str2int.containsKey(now)){
                // 如果这个单词的确属于目标单词的话
                // 要么出现过，要么没出现过
                if(str2int.get(now)==-1){
                    str2int.replace(now,pos);
                    nowcounter++;
                }else if (str2int.get(now)!=null){
                    // 简称已经在前面出现的话
                    // 需要将出现位置进行变更，在上一个出现位置之前出现的都设置为-1
                    int formerpos=str2int.get(now);
                    for (String before:str2int.keySet()){
                        if (str2int.get(before)<formerpos&&str2int.get(before)!=-1){
                            str2int.replace(before,-1);
                            nowcounter--;
                        }
                    }
                    str2int.replace(now,pos);
                }
            }else {
                // 如果不属于目标单词
                nowcounter=0;
                for (String mapword:str2int.keySet()){
                    str2int.replace(mapword,-1);
                }
            }
            if (nowcounter==wordsnum){
                int beginpos=Integer.MAX_VALUE;
                // 这边有个问题如果是有重合部分的话那就可能不在这里将值设置为-1
                // 而且是真的需要dp了
                for(String mapword:str2int.keySet()){
                    if(str2int.get(mapword)<beginpos){
                        beginpos=str2int.get(mapword);
                    }
                    // 用例中可能存在重合部分
//                    str2int.replace(mapword,-1);
                }
                res.add(beginpos);
            }
            pos+=lens;
        }
        return res;
    }
    public static void main(String[] args) {
        String str="barfoothefoobarman";
        String[] strs=new String[2];
        strs[0]="bar";
        strs[1]="foo";
//        strs[2]="best";
//        strs[3]="good";
//        strs[4]="wing";
        Leetcode30 lt30=new Leetcode30();
        System.out.println(lt30.findSubstr(str,strs));
    }
}
