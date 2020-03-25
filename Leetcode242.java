public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        //  最快的先用tochararray方法 并且cahr可以直接当作数字
        if (s==null&&t==null)
            return true;
        else if (s==null||t==null)
            return false;
        if (s.length()!=t.length())
            return false;
        int[] char_count=new int[26];
        for (int pos=0;pos<s.length();pos++){
            int now=(int)s.charAt(pos)-'a';
            char_count[now]++;
            now=(int)t.charAt(pos)-'a';
            char_count[now]--;
        }
        for (int i:char_count){
            if (i!=0)
                return false;
        }
        return true;
    }
}
