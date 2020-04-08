import java.util.Scanner;

public class Acmcoder_dp_gs {
    public int getgp(int needpos){
        Scanner scanner=new Scanner(System.in);
        int res=1;
        int base=1;
        int pos=1;
        while (pos<needpos){
            if (needpos<=pos+base){
                res+=needpos-pos;
                break;
            }
            // 到一个升到结尾
            pos+=base;
            res+=base;
            res--;
            pos++;
            base++;
        }
        return res;
    }

    public static void main(String[] args){
        Acmcoder_dp_gs acd=new Acmcoder_dp_gs();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(acd.getgp(scanner.nextInt()));
        }
    }
}
