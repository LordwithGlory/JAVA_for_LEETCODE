import java.util.ArrayList;
import java.util.List;

public class Leetcode_weekly_5380 {
    public List<String> stringMatching(String[] words) {
        List<String> res=new ArrayList<>();
        for (int subpos=0;subpos<words.length;subpos++){
            for (int pos=0;pos<words.length;pos++){
                if (pos==subpos||words[subpos].length()>=words[pos].length())
                    continue;
                if (words[pos].lastIndexOf(words[subpos])!=-1){
                    res.add(words[subpos]);
                    break;
                }
            }
        }
        return res;
    }
}
