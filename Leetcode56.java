import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        // 更快的方法是将每一个和后面的进行merge
        // merge一次之后设置为null
        // 最后统计所有非null的
        // 第一个维度必须被指定
        int[][] res=new int[intervals.length][2];
        int lens=intervals.length;
        // 排序方法：https://blog.csdn.net/qq_26580757/article/details/78136434
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]>o2[0]){
                    return 1;
                }else if (o1[0]==o2[0])
                    return 0;
                return -1;
            }
        });
        if (lens==0)
            return intervals;
        int respos=0;
        res[respos][0]=intervals[0][0];
        res[respos][1]=intervals[0][1];
        for (int i=1;i<lens;i++){
            if (intervals[i][0]<=res[respos][1]){
                if (res[respos][1]<intervals[i][1])
                    res[respos][1]=intervals[i][1];
                continue;
            }
            respos++;
            res[respos][0]=intervals[i][0];
            res[respos][1]=intervals[i][1];
        }
        // 这个方法导致最后输出的的确是null 而不是截断
//        res[respos+1]=null;
        int[][] resend=new int[respos+1][2];
        // 最后一个居然是length 震惊
        System.arraycopy(res,0,resend,0,respos+1);
        return resend;
//        List<int[]> tmpres=new ArrayList<>();
        // 这个导致的问题是他们所有的oneres最后边城一样的
        // 所以有问题，如果能够保证大家都不一样还是可以做的
        // 简称oneres的时候别直接加入oneres这个值
//        int[] oneres=new int[2];
//        int lens=intervals.length;
//        oneres[0]=intervals[0][0];
//        oneres[1]=intervals[0][1];
//        for (int i=1;i<lens;i++){
//            if (intervals[i][0]<=oneres[1]){
//                oneres[1]=intervals[i][1];
//                continue;
//            }
//            tmpres.add(oneres);
//            oneres[0]=intervals[i][0];
//            oneres[1]=intervals[i][1];
//        }
//        int[][] res=new int[tmpres.size()][2];
//        for (int pos=0;pos<tmpres.size();pos++){
//            res[pos][0]=tmpres.get(pos)[0];
//            res[pos][1]=tmpres.get(pos)[1];
//        }
//        return res;
    }
}
