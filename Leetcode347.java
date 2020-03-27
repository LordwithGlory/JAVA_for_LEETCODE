import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Leetcode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 最快的那个先sort然后
        // 做了一个count,list<interger>的map
        // 从最大的key往下找减找后面的key
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> mycount=new HashMap<>();
        for (int num:nums){
            int oldcount=mycount.getOrDefault(num,0);
            mycount.put(num,oldcount+1);
        }
        List<Map.Entry<Integer,Integer>> sorlist=new ArrayList<Map.Entry<Integer,Integer>>(mycount.entrySet());
        sorlist.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        int count=0;
        for (Map.Entry<Integer,Integer> pos:sorlist){
            if (count>=k)
                break;
            res.add(pos.getKey());
            count++;
        }
        return res;
    }
}
