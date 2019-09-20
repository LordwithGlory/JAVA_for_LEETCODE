import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public List<List<Integer>> get4sum(int[] nums,int target){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int nowpos=0;
        int len=nums.length;
        Arrays.sort(nums);
        for(;nowpos<len-2;nowpos++){
            if(nowpos>0&&nums[nowpos]==nums[nowpos-1])
                continue;
            int left=nowpos+1;
            int right=len-1;
            for(;left<right-1;left++){
                int mid=left+1;
                right=len-1;
                int tmptarget=target-nums[left]-nums[right]-nums[nowpos];
                if((left>nowpos+1)&&nums[left-1]==nums[left]){
                    continue;
                }
                while (right>left+1){
                    if(right!=len-1&&nums[right]==nums[right+1]){
                        right--;
                        continue;
                    }
                    tmptarget=target-nums[left]-nums[right]-nums[nowpos];
                    if(tmptarget>nums[right]){
                        break;
                    }else if(tmptarget<nums[left]){
                        right--;
                        continue;
                    }
                    int tmpl,tmpr;
                    tmpl=left+1;
                    tmpr=right-1;
                    while (tmpl<=tmpr){
                        mid=(tmpl+tmpr)/2;
                        if(nums[mid]>tmptarget){
                            tmpr=mid-1;
                        }else if(nums[mid]<tmptarget){
                            tmpl=mid+1;
                        }else {
                            // 发现存在答案中存在两个同样数字（但是这个数字只有一个），和right判断是否相同二者取其一
//                            if(mid==left||mid==right)
//                                break;
                            List<Integer> oneres=new ArrayList<Integer>();
                            oneres.add(nums[nowpos]);
                            oneres.add(nums[left]);
                            oneres.add(nums[mid]);
                            oneres.add(nums[right]);
                            // 存在例子因为没有这个条件因此right--的时候一直出现问题
                            // 当时应该也考虑下right是否和更右侧的right相同
                            if(res.contains(oneres)){
                                break;
                            }
                            res.add(oneres);
                            break;
                        }
                    }
                    right--;
                }
                // right上面一直在改变如果不重新赋值的话会影响判断
                right=len-1;
            }
        }
        return res;
     }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // version 1.0 没有考虑到右侧移动的情况
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len=nums.length;
        int nowpos,left,right,mid;
        for(nowpos=0;nowpos<len-3;nowpos++){
            if(nowpos!=0&&nums[nowpos]==nums[nowpos-1]){
                continue;
            }
            left=nowpos+1;
            for(;left<len-2;left++){
                mid=left+1;
                right=len-1;
                while (mid<right){
                    int thetmp=target-nums[left]-nums[right]-nums[nowpos];
                    if(thetmp<nums[left]){
                        right--;
                        continue;
                    }else if(thetmp>nums[right]){
                        break;
                    }
                    mid--;
                    while(nums[++mid]<thetmp);
                    if(nums[mid]==thetmp&&mid<right){
                        List<Integer> tmplist=new ArrayList<Integer>();
                        tmplist.add(nums[nowpos]);
                        tmplist.add(nums[left]);
                        tmplist.add(nums[mid]);
                        tmplist.add(nums[right]);
                        res.add(tmplist);
                        break;
                    }
                    mid++;
                }
            }
        }
        return res;
    }

    public static void main(String argv[]){
        int[] nums;
        int target;
        nums= new int[]{-1,2,2,-5,0,-1,4};
        target=3;
        Leetcode18 lt=new Leetcode18();
        System.out.println(lt.get4sum(nums,target));
    }
}
