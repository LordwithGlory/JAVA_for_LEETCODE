import java.util.ArrayList;
import java.util.List;

public class Leetcode75 {
    public void sortColors(int[] nums) {
        int twotag=nums.length-1;
        int zertag=0;
        for (int i=0;i<nums.length;i++){
            // 先检测2是因为后面可能是0
            // 如果先检测0的话前面不可能是2
            if (nums[i]==2){
                while (twotag>=0&&nums[twotag]==2)
                    twotag--;
                if (twotag>i){
                    nums[i]=nums[twotag];
                    nums[twotag]=2;
                }
            }
            if (nums[i]==0){
                while (zertag<nums.length&&nums[zertag]==0){
                    zertag++;
                }
                if (zertag<i){
                    nums[i]=nums[zertag];
                    nums[zertag]=0;
                }
            }
            if (zertag>=twotag)
                break;
        }
//        List<Integer> res=new ArrayList<Integer>();
//        int onetag=0;
//        for (int num:nums){
//            if (num==0){
//                res.add(0,0);
//                onetag++;
//            }else if (num==1){
//                res.add(onetag,1);
//            }else{
//                res.add(res.size(),2);
//            }
//        }
//        for (int i=0;i<nums.length;i++){
//            nums[i]=res.get(i);
//        }
    }
}
