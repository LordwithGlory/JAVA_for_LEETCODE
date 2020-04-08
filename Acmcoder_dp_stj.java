import java.util.Scanner;

public class Acmcoder_dp_stj {
    public int getnum(int floors){
        int[] res=new int[floors];
        if (floors==1)
            return 0;
        res[0]=1;
        res[1]=1;
        for (int i=2;i<floors;i++)
            res[i]=res[i-1]+res[i+1];
        return res[floors-1];
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        Acmcoder_dp_stj acd=new Acmcoder_dp_stj();
        while (cases>0){
            cases--;
            System.out.println(acd.getnum(scanner.nextInt()));
        }
    }
}
