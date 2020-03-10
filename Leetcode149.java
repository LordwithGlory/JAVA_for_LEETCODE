import java.util.*;

public class Leetcode149 {
    public int maxPoints(int[][] points) {
        int rowlen=points.length;
        if (rowlen<2)
            return rowlen;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]<o2[0])
                    return 1;
                else if (o1[0]>o2[0])
                    return -1;
                return 0;
            }
        });
        int collen=points[0].length;
        if (collen==0)
            return 0;
        Map<Double, Integer> mycount=new HashMap<>();
        int res=2;
        for (int pos=0;pos<rowlen;pos++){
            mycount.clear();
            int base=pos;
            while (pos<rowlen-1&&points[pos][1]==points[pos+1][1]&&points[pos][0]==points[pos+1][0])
                pos++;
            if (pos==rowlen-1&&pos!=base&&points[pos][0]==points[base][0]&&points[pos][1]==points[base][1]){
                pos++;
                if (res<pos-base+1){
                    return pos-base+1;
                }
            }
            base=pos-base+1;
            if (base>res)
                res=base;
            for (int nextpos=1+pos;nextpos<rowlen;nextpos++){
                double k=0;
                int tmpval=base;
                if (points[pos][0]==points[nextpos][0]){
                    k=Integer.MAX_VALUE;
                }else {
                    k=((float)points[pos][1]-points[nextpos][1])/(points[pos][0]-points[nextpos][0]);
                }
                if (mycount.containsKey(k))
                    tmpval=mycount.get(k)+1;
                else
                    tmpval=base+1;
                mycount.put(k,tmpval);
                if (tmpval>res)
                    res=tmpval;
            }
        }
        return res;
    }
}
