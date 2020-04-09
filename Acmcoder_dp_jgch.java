import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Acmcoder_dp_jgch {
    public int sendfoloer(int peoples,int send_time){
        Map<Integer,Integer> now_count=new HashMap<>();
        now_count.put(1,1);
        while (send_time>0){
            Map<Integer,Integer> next_count=new HashMap<>();
            for (int key:now_count.keySet()){
                int value=now_count.get(key);
                int nextkey=key-1;
                if (key==1)
                    nextkey=peoples;
                next_count.put(nextkey,value+next_count.getOrDefault(nextkey,0));
                nextkey=key+1;
                if (key==peoples)
                    nextkey=1;
                next_count.put(nextkey,value+next_count.getOrDefault(nextkey,0));
            }
            now_count=next_count;
            send_time--;
        }
        return now_count.getOrDefault(1,0);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Acmcoder_dp_jgch acd=new Acmcoder_dp_jgch();
        System.out.println(acd.sendfoloer(scanner.nextInt(),scanner.nextInt()));
    }
}
