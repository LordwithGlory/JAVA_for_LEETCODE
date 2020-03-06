import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    // 最快的那个憨批也没整map而是使用了char[]代替了string
    public List<List<String>> partition(String s) {
        if (s.length()==0)
            return null;
        List<List<String>> res=new ArrayList<List<String>>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==s.charAt(0)){
                int right=i;
                int left=0;
                boolean ispart=true;
                while (left<right){
                    if (s.charAt(left)==s.charAt(right)){
                        left++;
                        right--;
                        continue;
                    }
                    ispart=false;
                    break;
                }
                if (ispart){
                    String one=s.substring(0,i+1);
                    if (i==s.length()-1){
                        res.add(new ArrayList<String>());
                        res.get(res.size()-1).add(one);
                        continue;
                    }
                    for (List<String> thelist:partition(s.substring(i+1))){
                        thelist.add(0,one);
                        res.add(new ArrayList<String>(thelist));
                    }
                }
            }
        }
        return res;
    }
}
