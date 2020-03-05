import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        // 除了那几个先sort的狗之外这个是最快的，每次都找连续的最小的那个，减少很多工作量
//        for(int num: nums) {
//            hset.add(num);
//        }
//
//        int longestStreak = 0;
//        for(int num: hset) {
//            if(!hset.contains(num-1)) {
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while(hset.contains(currentNum + 1)) {
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//                longestStreak = Math.max(longestStreak, currentStreak);
//            }
//        }
        if (nums.length<2)
            return nums.length;
        int res=1;
        Set<Integer> myset=new HashSet<>();
        for (int num:nums){
            if (myset.contains(num))
                continue;
            int tmpres=1;
            int cur=num;
            while (myset.contains(--cur))tmpres++;
            cur=num;
            while (myset.contains(++cur))tmpres++;
            if (tmpres>res)
                res=tmpres;
            myset.add(num);
        }
        return res;
//        Map<Integer,Integer> neighor=new HashMap<Integer, Integer>();
        // 使用map做不到实时更新
//        for (int num:nums){
//            if (neighor.containsKey(num))
//                continue;
//            int tmpres=1;
//            if (neighor.containsKey(num-1))
//                tmpres+=neighor.get(num-1);
//            if (neighor.containsKey(num+1))
//                tmpres+=neighor.get(num+1);
//            neighor.put(num,tmpres);
        // 这回还应该更新小于他和大于它的
//            if (tmpres>res)
//                res=tmpres;
//        }
//        return res;
    }
}
