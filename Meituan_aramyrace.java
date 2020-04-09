import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Meituan_aramyrace {
    public void getprice(){
        Scanner scanner=new Scanner(System.in);
        Map<Integer,Integer> go_order=new HashMap<>();
        int cand=scanner.nextInt();
        for (int sort=0;sort<cand;sort++){
            int num=scanner.nextInt();
            go_order.put(num,sort);
        }
        int[] get_order=new int[cand];
        int res=0;
        for (int sort=0;sort<cand;sort++){
            int num=scanner.nextInt();
            get_order[sort]=num;
        }
        for (int sort=0;sort<cand-1;sort++){
            int go=go_order.get(get_order[sort]);
            if (sort<go){
                res++;
                continue;
            }
            for (int run=sort+1;run<cand;run++){
                if (go_order.get(get_order[run])<go){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args){
        Meituan_aramyrace mt=new Meituan_aramyrace();
        Scanner scanner=new Scanner(System.in);
        mt.getprice();
    }
}
