import java.util.Arrays;
import java.util.Comparator;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 最快的那个很有意思
        // 首先确定插入的位置根据大小
        // 然后将插入之前位置copy
        // 插入位置可能是最终也可能是第一个位置
        // 之后将插入位置进行比较判断
        // 将范围之后的进行拷贝
        int lens=intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]>o2[0])
                    return 1;
                if (o1[1]<o2[1])
                    return -1;
                return 0;
            }
        });
        int endsize=0;
        boolean hasinert=false;
        int insertpos=-1;
        for (int pos=0;pos<lens;pos++){
            if (!hasinert&&newInterval[0]<=intervals[pos][1]&&newInterval[1]>=intervals[pos][0]){
                intervals[pos][1]=intervals[pos][1]>newInterval[1]?intervals[pos][1]:newInterval[1];
                intervals[pos][0]=intervals[pos][0]<newInterval[0]?intervals[pos][0]:newInterval[0];
                hasinert=true;
            }
            if(!hasinert&&intervals[pos][1]<newInterval[0])
                insertpos=pos;
            if (pos>0&&intervals[pos][0]<=intervals[pos-1][1]){
                intervals[pos][0]=intervals[pos-1][0];
                intervals[pos][1]=intervals[pos][1]>intervals[pos-1][1]?intervals[pos][1]:intervals[pos-1][1];
                intervals[pos-1]=null;
                continue;
            }
            endsize++;
        }
        // 如果是最大或者最小值的话需要再多一个位置
        if (!hasinert)
            endsize++;
        // 在leetcode里面没有第二维度也不行
        int[][] res=new int[endsize][2];
        int nowpos=0;
        // 党输入是一个空的时候
        if (lens==0){
            res[0][0]=newInterval[0];
            res[0][1]=newInterval[1];
            return res;
        }
        if (!hasinert&&insertpos==-1){
            // 插入第一个元素
            // 该元素的最小值小于已经merge的最大的值
            res[nowpos][0]=newInterval[0];
            res[nowpos][1]=newInterval[1];
            nowpos++;
        }
        for (int i=0;i<lens;i++){
            if (intervals[i]==null)
                continue;
            res[nowpos][0]=intervals[i][0];
            res[nowpos][1]=intervals[i][1];
            nowpos++;
            if (!hasinert&&insertpos==i){
                res[nowpos][0]=newInterval[0];
                res[nowpos][1]=newInterval[1];
                nowpos++;
            }
        }

        return res;
    }
}
