import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode76 {
    // 最快的那个狗用的数组记述来进行减法操作
    // 为啦防止重复 他是在该数量大于等于0 时候进行n--（判断len的）
    // 然后每个都进行减法 当n为0 当时候来寻找第一个pos，
    // 此时进行假发，找到第一个不小于0的
    public String minWindow(String s, String t) {
        Map<Character,Integer> char_times=new HashMap<>();
        Map<Character, List> char_poses=new HashMap<>();
        int nowlen=0;
        String res=s+" ";
        for (int pos=0;pos<t.length();pos++){
            char c=t.charAt(pos);
            char_times.put(c,char_times.getOrDefault(c,0)+1);
            if (!char_poses.containsKey(c))
                char_poses.put(c,new ArrayList<Integer>());
        }
        for (int pos=0;pos<s.length();pos++){
            char c=s.charAt(pos);
            if (char_times.containsKey(c)){
                List<Integer> poses=char_poses.get(c);
                if (poses.size()<char_times.get(c))
                    nowlen++;
                else
                    poses.remove(0);
                poses.add(pos);
            }
            if (nowlen==t.length()){
                int minpos=pos;
                for (List<Integer> onepos:char_poses.values()){
                    minpos=Math.min(minpos,onepos.get(0));
                }
                if (pos-minpos+1<res.length())
                    res=s.substring(minpos,pos+1);
            }
        }
        if (res.length()>s.length())
            res="";
        return res;
    }
}
