import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Meituan_jinzita {
    public void outways(){
        Scanner scanner=new Scanner(System.in);
        int steps=scanner.nextInt();
        Map<Integer,Integer> myrouth=new HashMap<>();
        myrouth.put(0,1);
        for (int i=0;i<steps;i++){
            Map<Integer,Integer> nextpoint=new HashMap<>();
            for (int key:myrouth.keySet()){
                for (int next=0;next<4;next++){
                    if (next==key)
                        continue;
                    int value=nextpoint.getOrDefault(next,0)+myrouth.get(key);
                    nextpoint.put(next,value%1000000007);
                }
            }
            myrouth=nextpoint;
        }
        System.out.println(myrouth.getOrDefault(0,0)%1000000007);
    }

    public static void main(String[] args){
        Meituan_jinzita mt=new Meituan_jinzita();
        mt.outways();
    }
}
