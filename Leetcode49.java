import java.util.*;

public class Leetcode49 {
    // 速度更快的那个不是使用sort排序
    // 而是用字符串代表每个字符出现的多少而来作为key
//    String getNormalizedString(String str){
//        char[] norStr = new char[26];
//        for(int i=0;i<str.length();i++){
//            norStr[str.charAt(i)-'a']++;
//        }
//
//        return new String(norStr);
//    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> themap=new HashMap<String, List<String>>();
        List<List<String>> res= new ArrayList<List<String>>();
        for (int i=0;i<strs.length;i++){
            char[] haslist=strs[i].toCharArray();
            Arrays.sort(haslist);
            // 直接使用字符串tostring函数会报错
            String tmostr=Arrays.toString(haslist);
            if (themap.containsKey(tmostr)){
                List<String> tmplist=themap.get(tmostr);
                tmplist.add(strs[i]);
            }else {
                List<String> newlist=new ArrayList<String>();
                newlist.add(strs[i]);
                themap.put(tmostr,newlist);
            }
        }
        for (List<String> thelist:themap.values()){
            res.add(thelist);
        }
        return res;
    }
}
