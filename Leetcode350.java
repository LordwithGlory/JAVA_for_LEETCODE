import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 最快的那个是先进行sort然后来获得最终数组
        Map<Integer,Integer> mymap=new HashMap<>();
        for (int num:nums1)
            mymap.put(num,mymap.getOrDefault(num,0));
        int maxlen=Math.min(nums1.length,nums2.length);
        int[] res=new int[maxlen];
        int count=0;
        for (int num:nums2){
            if (mymap.containsKey(num)&&mymap.get(num)>0){
                res[count++]=num;
                mymap.put(num,mymap.get(num)-1);
            }
        }
        return Arrays.copyOf(res,count);
    }
}