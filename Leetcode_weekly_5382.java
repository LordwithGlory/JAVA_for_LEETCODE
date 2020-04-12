import java.util.HashMap;
import java.util.Map;

public class Leetcode_weekly_5382 {
    public String entityParser(String text) {
        Map<String,String> parser=new HashMap<>();
        parser.put("&quot;","\"");
        parser.put("&apos;","'");
        parser.put("&amp;","&");
        parser.put("&gt;",">");
        parser.put("&lt;","<");
        parser.put("&frasl;","///");
        String res="";
        for (int pos=0;pos<text.length();pos++){
            boolean hasadd=false;
            if (text.charAt(pos)=='&'){
                String sub="&";
                for (int nextpos=pos+1;nextpos<pos+7&&nextpos<text.length();nextpos++){
                    sub+=text.charAt(nextpos);
                    if (text.charAt(nextpos)==';'){
                        if (!parser.containsKey(sub))
                            break;
                        hasadd=true;
                        res+=parser.get(sub);
                        pos=nextpos;
                        break;
                    }else if (text.charAt(nextpos)=='&')
                        break;
                }
            }
            if (!hasadd)
                res+=text.charAt(pos);
        }
        return res;
    }
}
