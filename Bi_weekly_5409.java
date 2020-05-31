import java.util.HashSet;
import java.util.Set;

public class Bi_weekly_5409 {
    public boolean hasAllCodes(String s, int k) {
        Set<String> resset=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        char[] s_char=s.toCharArray();
        int lens=(int)Math.pow(2,k);
        for (int pos=0;pos<s.length();pos++){
            if (pos<k-1){
                sb.append(s_char[pos]);
                continue;
            }
            sb.append(s_char[pos]);
            if (resset.contains(sb)){
                sb.deleteCharAt(0);
                continue;
            }else{
                resset.add(sb.toString());
                sb.deleteCharAt(0);
            }
            if (resset.size()==lens)
                return true;
        }
        return false;
    }
}
