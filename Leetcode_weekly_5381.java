import java.util.ArrayList;
import java.util.List;

public class Leetcode_weekly_5381 {
    public int[] processQueries(int[] queries, int m) {
        int array_len=queries.length;
        int[] res=new int[array_len];
        List<Integer> mylist=new ArrayList<>();
        for (int value=1;value<=m;value++)
            mylist.add(value);
        int respos=0;
        for (int qpos=0;qpos<array_len;qpos++){
            int mypos=mylist.indexOf(queries[qpos]);
            res[respos]=mypos;
            mylist.remove(mypos);
            mylist.add(0,queries[qpos]);
            respos++;
        }
        return res;
    }
}
