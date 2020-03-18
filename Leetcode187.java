import java.util.*;

public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        // 最快那个加了一个hashset确保出现的次数
        // 最快那个使用二进制来确定是否是一个数字六批
//        int sequence = 0;
//        for(int j=i; j< i+10; j++)
//        {
//            // Shift existing sequence by two to make space for the new character coming
//            sequence = sequence << 2;
//
//            // Copy the character from the map and paste those two bits in the newly created space. Read bit wise OR.
//            sequence = sequence | map[s.charAt(j) - 'A'];
//        }
        List<String> res=new ArrayList<>();
        if (s.length()<11)
            return res;
        StringBuffer tmp=new StringBuffer();
        Set<String> findstr=new HashSet<>();
        for (int pos=0;pos<s.length();pos++){
            tmp.append(s.charAt(pos));
            if (pos<9)
                continue;
            String tmpstr=tmp.toString();
            if (findstr.contains(tmpstr)&&!res.contains(tmpstr))
                res.add(new String(tmpstr));
            else if (!findstr.contains(tmpstr))
                findstr.add(new String(tmpstr));
            tmp.deleteCharAt(0);
        }
        return res;
    }
}
