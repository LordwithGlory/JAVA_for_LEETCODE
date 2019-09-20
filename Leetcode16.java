public class Leetcode16 {
    // 写一个人家例程的方法——先进行排序
    // 之后确定最左侧的之后左右两侧同时开工（一个while循环）
    // 一个值是最左侧加一开始一个值的最高位开始
    // 如果三个值的和小于则左侧加加否则右侧减减
    public int threeSumClosest(int[] nums, int target) {
        int res,len,beg,sed,max;
        if(target>=0){
            res=Integer.MAX_VALUE;
        }else{
            res=Integer.MIN_VALUE;
        }
        len=nums.length;
        for(beg=0;beg<len-2;beg++){
            if(beg!=0&&nums[beg]==nums[beg-1]){
                continue;
            }
            for(sed=beg+1;sed<len-1;sed++){
                if(sed!=beg+1&&nums[sed]==nums[sed-1]){
                    continue;
                }
                for (max=sed+1;max<len;max++){
                    if(max!=sed+1&&nums[max]==nums[max-1])
                        continue;
                    int sum=nums[beg]+nums[sed]+nums[max];
                    if(Math.abs(sum-target)<Math.abs(res-target)){
                        res=sum;
                        if(res==target)
                            return res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] input={1,4,8,0,2,4,-7};
        int target=9;
        Leetcode16 solution=new Leetcode16();
        System.out.println(solution.threeSumClosest(input,target));
    }
}
