import java.util.ArrayList;
import java.util.List;

public class Leetcode295 {
    /** initialize your data structure here. */
    // 最快那个使用了大小堆
    List<Integer> media;
    public Leetcode295() {
        media=new ArrayList<>();
    }

    public void addNum(int num) {
        if (media.size()==0)
            media.add(num);
        else {
            int pos=0;
            while (pos<media.size()&&media.get(pos)>num)
                pos++;
            media.add(pos,num);
        }
    }

    public double findMedian() {
        int lens=media.size();
        if (lens%2!=0)
            return media.get(lens/2);
        return (media.get(lens/2)+media.get(lens/2-1))/2.0;
    }
}
