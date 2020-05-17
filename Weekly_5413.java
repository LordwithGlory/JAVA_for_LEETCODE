import java.util.*;

public class Weekly_5413 {
    public String arrangeWords(String text) {
        text=text.toLowerCase();
        String[] splitlist=text.split(" ");
        List<Integer> keys=new ArrayList<>();
        Map<Integer,List<String>> lens_words=new HashMap<>();
        for (String onestr:splitlist){
            int lens=onestr.length();
            if (!lens_words.containsKey(lens)){
                lens_words.put(lens,new ArrayList<String>());
                keys.add(lens);
            }
            lens_words.get(lens).add(onestr);
        }
        Collections.sort(keys);
        StringBuilder res= new StringBuilder();
        for (int key:keys){
            for (String one:lens_words.get(key)){
                if (res.length()!=0)
                    res.append(" ");
                res.append(one);
            }
        }
        char first=res.charAt(0);
        first-=32;
        res.setCharAt(0,first);
        return res.toString();
    }
}
