public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        int lens=nums.length;
        int left,right;
        int leftpos=-1;
        int rightpos=-1;
        left=0;
        right=lens-1;
        if (lens==1){
            if (nums[0]==target){
                res[0]=0;
                res[1]=0;
                return res;
            }else {
                res[0]=-1;
                res[1]=-1;
                return res;
            }
        }
        while (left<right){
            int mid=(left+right)/2;
            if (nums[left]==target){
                leftpos=left;
                break;
            }else if (nums[right]==target){
                leftpos=right;
                break;
            }else if (nums[mid]==target){
                leftpos=mid;
                break;
            }
            if (nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        if (leftpos==-1){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        rightpos=leftpos;
        while (leftpos>=0&&nums[leftpos]==target){
            leftpos--;
        };
        while (rightpos<lens&&nums[rightpos]==target){
            rightpos++;
        };
        res[0]=leftpos+1;
        res[1]=rightpos-1;
        System.out.println(res[0]);
        System.out.println(res[1]);
        return res;
    }
    public static void main(String[] args){
        int[] thelist={5,7,7,8,8,10};
        Leetcode34 l33=new Leetcode34();
        System.out.println(l33.searchRange(thelist,8));
    }
}
