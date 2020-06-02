import java.util.*;

public class Pdd_0602_3 {
    public void remalloc(){
        Scanner scanner=new Scanner(System.in);
        int people=scanner.nextInt();
        int round=scanner.nextInt();
        List<Integer> coins=new LinkedList<>();
        while (people>0){
            people--;
            coins.add(scanner.nextInt());
        }
        Collections.sort(coins);
        while (round>0){
            round--;
            int maxnum=coins.remove(coins.size()-1);
            int minnum=coins.remove(0);
            if (maxnum-minnum>1){
                maxnum--;
                minnum++;
            }else{
                coins.add(0,minnum);
                coins.add(coins.size(),maxnum);
                continue;
            }
//            coins.add(maxnum);
//            coins.add(minnum);
//            Collections.sort(coins);
//            continue;
            int minpos=0;
            while (minpos<coins.size()){
                if (coins.get(minpos)>=minnum){
                    coins.add(minpos,minnum);
                    break;
                }
                minpos++;
            }
            if (minpos==coins.size())
                coins.add(minnum);
            int maxpos=coins.size()-1;
            while (maxpos>=0){
                if (coins.get(maxpos)<=maxnum){
                    coins.add(maxpos+1,maxnum);
                    break;
                }
                maxpos--;
            }
            if (maxpos<0)
                coins.add(0,maxnum);
        }
        System.out.println(coins.get(coins.size()-1)-coins.get(0));
    }

    public static void main(String[] args){
        Pdd_0602_3 pdd=new Pdd_0602_3();
        pdd.remalloc();
    }
}
