import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 建立list： https://blog.csdn.net/w405722907/article/details/84325205
// main函数中如果没有String[] args就不能运行
public class Leetcode15 {
    public List<List<Integer>>threeSum(int[] nums){
        List<List<Integer>> backres=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len=nums.length;
        int mid=len/2;
        if(len<3||len==0)
            return backres;
        // 最小的非负数
        while(mid>=0&&nums[mid]>0){
            mid--;
        }
        if(mid<0)
            return backres;
        while(mid<len&&nums[mid]<0){
            mid++;
        }
        if(mid==len)
            return  backres;
        for(int min=0;min<=mid&&nums[min]<=0;min++){
            if(min!=0&&nums[min-1]==nums[min]){
                continue;
            }
            for(int max=len-1;max>=mid&&max>min;max--){
                if(max!=len-1&&nums[max+1]==nums[max]){
                    continue;
                }
                if(nums[min]+nums[max]>0){
                    int temp=mid;
                    if(nums[temp]>0)
                        temp--;
                    while(temp>min&&nums[temp]<=0){
                        if(nums[min]+nums[temp]+nums[max]==0){
                            backres.add(Arrays.asList(nums[min],nums[temp],nums[max]));
                            break;
                        }else if(nums[min]+nums[temp]+nums[max]<0){
                            break;
                        }
                        temp--;
                    }
                }else if(nums[min]+nums[max]<=0){
                    int temp=mid<max?mid:max-1;
                    if(min==temp){
                        temp++;
                        if(temp==max)
                            continue;
                    }
                    while(temp<max&&temp>min){
                        if(nums[min]+nums[temp]+nums[max]==0){
                            backres.add(Arrays.asList(nums[min],nums[temp],nums[max]));
                            break;
                        }else if (nums[min]+nums[temp]+nums[max]>0){
                            break;
                        }
                        temp++;
                    }
                }
            }
        }
        return backres;
    }

    public static void main(String[] args){
        Leetcode15 solution=new Leetcode15();
        int[] mylist={-1,0,1,2,-1,-4};
        List<List<Integer>> backlist=solution.threeSum(mylist);
        System.out.println(backlist);
    }
}
