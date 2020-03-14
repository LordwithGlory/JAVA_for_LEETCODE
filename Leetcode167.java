import java.util.HashSet;
import java.util.Set;

public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length<2)
            return null;
        int righ=numbers.length-1;
        int left=0;
        while (left<righ){
            while (numbers[left]+numbers[righ]>target&&left<righ)
                righ--;
            if (numbers[left]+numbers[righ]==target){
                int[] res=new int[2];
                res[0]=left+1;
                res[1]=righ+1;
                return res;
            }
            left++;
        }
        return null;
        // 理解错了以为是必须相邻
//        if (numbers.length==1)
//            return null;
//        int left=1;
//        int righ=numbers.length-1;
//        if (numbers.length==2&&numbers[0]+numbers[1]==target){
//            int[] res=new int[2];
//            res[0]=1;
//            res[1]=2;
//            return res;
//        }
//        while (left<righ){
//            int mid=(left+righ)/2;
//            int sum=numbers[mid]+numbers[mid-1];
//            if (sum==target){
//                int[] res=new int[2];
//                res[0]=mid;
//                res[1]=mid+1;
//                return res;
//            }else if (sum<target){
//                left=mid+1;
//            }else
//                righ=mid-1;
//        }
//        return null;
    }
}
