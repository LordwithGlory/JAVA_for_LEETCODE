package JAVA_for_LEETCODE;

import java.util.Arrays;

public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        int numlen=nums.length;
        if(numlen==1)
            return;
        if (numlen==2){
            int tmp=nums[0];
            nums[0]=nums[1];
            nums[1]=tmp;
            return;
        }
        int pos=numlen-2;
        for(;pos>=0;pos--){
            if(nums[pos]<nums[pos+1]){
                break;
            }
        }
        if (pos==-1){
            Arrays.sort(nums);
            return;
        }
        int changepos=numlen-1;
        while (nums[changepos]<=nums[pos])
            changepos--;
        int tmp=nums[pos];
        nums[pos]=nums[changepos];
        nums[changepos]=tmp;
        // 关于自带排序:https://blog.csdn.net/tt_twilight/article/details/70859804
        // 速度比我的快的是一个用swap代替快排的
        Arrays.sort(nums,pos+1,numlen);
        return;
    }
}
