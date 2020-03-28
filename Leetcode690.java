import java.util.*;

public class Leetcode690 {
    class Employee{
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> id_enmployee=new HashMap<>();
        for (Employee e:employees)
            id_enmployee.put(e.id,e);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(id);
        int res=0;
        while (!queue.isEmpty()){
            Employee e=id_enmployee.get(queue.poll());
            res+=e.importance;
            for (int sub:e.subordinates)
                queue.add(sub);
        }
        return res;
    }
}
