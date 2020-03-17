import java.util.Arrays;
import java.util.Comparator;

public class Leetcode179 {
    // 最快的那个几乎是自己手撸的代码
    public String largestNumber(int[] nums) {
        String[] strnum=new String[nums.length];
        for (int pos=0;pos<nums.length;pos++)
            strnum[pos]=Integer.toString(nums[pos]);
        Arrays.sort(strnum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String first=o1+o2;
                String secnd=o2+o1;
                return -first.compareTo(secnd);
            }
        });
        String res=new String("");
        for (String num:strnum)
            res+=num;
        int pos=0;
        while (pos<res.length()&&res.charAt(pos)=='0'){
            pos++;
        };
        pos=Math.min(pos,res.length()-1);
        return res.substring(pos);
    }
}
