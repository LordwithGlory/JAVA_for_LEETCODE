import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Weekly_5417 {
    public int maxVowels(String s, int k) {
        int res=0;
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        s=s.toLowerCase();
        char[] allchar=s.toCharArray();
        int pos=0;
        int mycount=0;
        for (;pos<k&&pos<allchar.length;pos++){
            if (vowels.contains(allchar[pos]))
                mycount++;
        }
        res=mycount;
        for (;pos<allchar.length;pos++){
            if (vowels.contains(allchar[pos-k]))
                mycount--;
            if (vowels.contains(allchar[pos])){
                mycount++;
                res= Math.max(mycount,res);
            }
        }
        return res;
    }
}
