import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode447 {
    public int numberOfBoomerangs(int[][] points) {
        int plen=points.length;
        int res=0;
        Map<Integer,Integer> distances=new HashMap<>();
        for (int pos=0;pos<plen;pos++){
            int x=points[pos][0];
            int y=points[pos][1];
            distances.clear();
            for (int nextpos=0;nextpos<plen;nextpos++){
                if (nextpos==pos)
                    continue;
                int nextx=points[nextpos][0];
                int nexty=points[nextpos][1];
                int dis=Math.abs((nextx-x)*(nextx-x)+(nexty-y)*(nexty-y));
                int tmp=distances.getOrDefault(dis,0);
                res+=tmp;
                distances.put(dis,tmp+1);
            }
        }
        return res;
    }

    public static void main(String[] args){
        Leetcode447 lc=new Leetcode447();
        int[][] points={{0,0},{1,0},{2,0}};
        lc.numberOfBoomerangs(points);
    }
}
