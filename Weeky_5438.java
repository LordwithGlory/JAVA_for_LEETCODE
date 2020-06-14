import javax.swing.undo.UndoableEdit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weeky_5438 {
    public int minDays(int[] bloomDay, int m, int k) {
        int weneed=m*k;
        if (weneed>bloomDay.length)
            return -1;
        int[] thebloom= Arrays.copyOf(bloomDay,bloomDay.length);
        Arrays.sort(thebloom);
        int theday=-1;
        for (;weneed<=bloomDay.length;weneed++){
            while (weneed<bloomDay.length&&thebloom[weneed]==thebloom[weneed-1])
                weneed++;
            theday=thebloom[weneed-1];
            int count=0;
            for (int pos=0;pos<bloomDay.length;pos++){
                while (pos<bloomDay.length&&bloomDay[pos]>theday)
                    pos++;
                int next=pos+1;
                while (next<bloomDay.length&&bloomDay[next]<=theday)
                    next++;
                count+=(next-pos)/k;
                pos=next;
                if(count>=m)
                    break;
            }
            if (count>=m)
                break;
        }
        return theday;
    }

    public static void main(String[] args){
        int[] days={1,10,3,10,2};
        Weeky_5438 w=new Weeky_5438();
        w.minDays(days,3,1);
    }
}
