import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Weekly_5406 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Set<Integer> pathes=new HashSet<>();
        int res=0;
        pathes.add(0);
        int[] parents=new int[edges.length];
        for (int pos=0;pos<edges.length;pos++){
            int son=edges[pos][1];
            parents[son]=edges[pos][0];
        }
        for (int pos=0;pos<hasApple.size();pos++){
            if (hasApple.get(pos)){
                int nowpos=pos;
                while (!pathes.contains(nowpos)){
                    res+=2;
                    pathes.add(nowpos);
                    nowpos=parents[nowpos];
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Weekly_5406 wk=new Weekly_5406();
        List<Boolean> hashes= Arrays.asList(false,false,true,false,false,true,false);
        wk.minTime(0,null,hashes);
    }
}
