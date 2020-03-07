import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode140 {
    Map<Integer,List<String>> mylist=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 他们用的是list<String>[]数组而不是map，然后进行dfs操作
        List<String> res=new ArrayList<String>();
        if (s==null||s.length()==0)
            return null;
        if (mylist.containsKey(s.length()))
            return mylist.get(s.length());
        for (String word:wordDict){
            if (s.indexOf(word,0)==0){
                List<String> others=wordBreak(s.substring(word.length()),wordDict);
                if (others==null)
                    res.add(word);
                else {
                    for (String myword:others)
                        res.add(word+" "+myword);
                }
            }
        }
        mylist.put(s.length(),new ArrayList<>(res));
        return res;
    }
}
