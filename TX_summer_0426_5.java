import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TX_summer_0426_5 {
    public String divide(String number){
        int lastone=0;
        String res="";
        for (int pos=0;pos<number.length();pos++){
            lastone*=10;
            int now=number.charAt(pos)-'0';
            now+=lastone;
            if (pos==0&&now<2)
                continue;
            lastone=now%2;
            res+=Integer.toString(now/2);
        }
        return res;
    }
    public void getParent(){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        System.out.println(cases);
        scanner.nextLine();
        while (cases>0){
            String nodenum=scanner.nextLine();
            int spacepos=nodenum.indexOf(' ');
            nodenum=nodenum.substring(0,spacepos);
            int parentfloor=Integer.parseInt(nodenum.substring(spacepos+1));
            List<String> everyfloor=new ArrayList<>();
            nodenum=divide(nodenum);
            while (!nodenum.equals("")){
                everyfloor.add(0,nodenum);
                nodenum=divide(nodenum);
            }
//            for (int num:everyfloor)
//                System.out.print(num+" ");
//            System.out.println();
            if (parentfloor>everyfloor.size()){
                System.out.println(-1);
                continue;
            }
            System.out.println(everyfloor.get(parentfloor-1));
        }
    }

    public static void main(String[] args){
        TX_summer_0426_5 tx=new TX_summer_0426_5();
        tx.getParent();
    }
}
