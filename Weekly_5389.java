import com.sun.source.tree.WhileLoopTree;

import javax.print.DocFlavor;
import java.util.*;

public class Weekly_5389 {
//    public List<List<String>> display(List<List<String>> orders){
//        Map<String,List<String>> dish_tables=new HashMap<>();
//        for (List<String> order:orders){
//            String table=order.get(1);
//            String dish=order.get(2);
//            if (!dish_tables.containsKey(dish))
//                dish_tables.put(dish,new ArrayList<>());
//            dish_tables.get(dish).add(table);
//        }
//        List<Map.Entry<String,List<String>>> mylist=new ArrayList<>(dish_tables.entrySet());
//        Collections.sort(mylist, new Comparator<Map.Entry<String, List<String>>>() {
//            @Override
//            public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
//                return o1.getKey().compareTo(o2.getKey());
//            }
//        });
//        List<String> dishes=new ArrayList<>();
//        dishes.add("Table");
//        for (String dish:dish_tables.keySet())
//            dishes.add(dish);
//    }
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res=new ArrayList<>();
        List<String> dishes=new ArrayList<>();
        Map<Integer,List<Integer>> mymap=new HashMap<>();
        for (List<String> order:orders){
            int table=Integer.parseInt(order.get(1));
            String dish=order.get(2);
            int pos=dishes.size();
            if (dishes.contains(dish))
                pos=dish.indexOf(dish);
            else
                dishes.add(dish);
            if (!mymap.containsKey(table))
                mymap.put(table,new ArrayList<>());
            List<Integer> tabledish=mymap.get(table);
            while (tabledish.size()<=pos)
                tabledish.add(0);
            tabledish.add(pos,tabledish.remove(pos)+1);
        }
        Map<String,Integer> dishpos=new HashMap<>();
        for (int pos=0;pos<dishes.size();pos++){
            dishpos.put(dishes.get(pos),pos);
        }
        List<Map.Entry<String,Integer>> tmpdish=new ArrayList<>(dishpos.entrySet());
        Collections.sort(tmpdish, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                String key1=o1.getKey()+o2.getKey();
                String key2=o2.getKey()+o1.getKey();
                return key1.compareTo(key2);
            }
        });
        List<String> one=new ArrayList<>();
        one.add("Table");
        for (String onedish:dishpos.keySet())
            one.add(onedish);
        res.add(one);
        for (int key:mymap.keySet()){
            List<String> onelist=new ArrayList<>();
            onelist.add(Integer.toString(key));
            List<Integer> tmp=mymap.get(key);
            for (String dish:dishpos.keySet()){
                int pos=dishpos.get(dish);
                if (tmp.size()<=pos)
                    onelist.add("0");
                else
                    onelist.add(Integer.toString(tmp.get(pos)));
            }
            res.add(onelist);
        }
        return res;
    }

    public List<List<String>> displayT(List<List<String>> orders){
        Map<Integer,List<String>> table_dishes=new TreeMap<>(
//                new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        return Integer.parseInt(o1)-Integer.parseInt(o2);
//                    }
//                }
        );
        List<String> dish_order=new ArrayList<>();
        for (List<String> order:orders){
             bi
        }
        dish_order.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        dish_order.add("Table");
        List<List<String>> res=new ArrayList<>();
        res.add(dish_order);
        for (Map.Entry<Integer,List<String>> entry:table_dishes.entrySet()){
            List<String> onelist=new ArrayList<>();
            onelist.add(Integer.toString(entry.getKey()));
            int[] counts=new int[dish_order.size()];
            for (String mydish:entry.getValue()){
                counts[dish_order.indexOf(mydish)]++;
            }
            for (int pos=1;pos<dish_order.size();pos++)
                onelist.add(Integer.toString(counts[pos]));
            res.add(onelist);
        }
        return res;
    }
}
