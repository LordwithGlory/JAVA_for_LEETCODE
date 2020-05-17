import java.util.Scanner;

public class Kick_0517_1 {
    public void getthedown(){
        Scanner scanner=new Scanner(System.in);
        // case数量
        int cases=scanner.nextInt();
        for (int mycase=1;mycase<=cases;mycase++){
            int res=0;
            // 输入长度
            int lens=scanner.nextInt();
            // k的值也就是递减的最大值
            int maxnum=scanner.nextInt();
            // 递减情况下的最大值（从k到1）
            int tmpmaxnum=maxnum;
            for (int pos=0;pos<lens;pos++){
                int tmpint=scanner.nextInt();
                if (tmpint==tmpmaxnum){
                    if (tmpint==1){
                        // 如果为1并且已经递减到1 则res++
                        tmpmaxnum=maxnum;
                        res++;
                    }else
                        tmpmaxnum--;
                }else
                    tmpmaxnum=maxnum;
            }
            System.out.println("Case #"+mycase+": "+res);
        }
    }

    public static void main(String[] args){
        Kick_0517_1 kick=new Kick_0517_1();
        kick.getthedown();
    }
}
