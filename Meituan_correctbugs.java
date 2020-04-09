import java.util.Scanner;

public class Meituan_correctbugs {
    public void correcg(){
        Scanner scanner=new Scanner(System.in);
        int left=0;
        int bugs=scanner.nextInt();
        int right=bugs;
        int days=scanner.nextInt();
        while (left<right){
            int mid=(left+right)/2;
            int corrects=mid;
            int daycorrc=mid;
            while (daycorrc>0){
                daycorrc/=days;
                corrects+=daycorrc;
            }
            if (corrects>=bugs)
                right=mid;
            else
                left=mid+1;
        }
        System.out.println(left);
    }

    public static void main(String[] args){
        Meituan_correctbugs mt=new Meituan_correctbugs();
        mt.correcg();
    }
}
