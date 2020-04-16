import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ali_0415_gjjl {
    public int max_diff(int[] curture, int right, int left, List<Integer> seats,int seatslen,int[][] dp){
        if (right==left)
            return 0;
        // 可以考虑dp
        if (dp[left][right]!=0)
            return dp[left][right];
        int res=0;
        int myleft=seats.get(0);
        int addleft2left=Math.abs(myleft-curture[left]);
        int addrigh2left=Math.abs(myleft-curture[right-1]);
        int addleft=Math.max(addleft2left,addrigh2left);
        int myrigh=seats.get(seatslen-1);
        int addrigh2righ=Math.abs(myrigh-curture[right-1]);
        int addleft2righ=Math.abs(myrigh-curture[left]);
        int addright=Math.max(addrigh2righ,addleft2righ);
        int maxnum=Math.max(addleft,addright);
        if (addleft==addleft2left){
            seats.add(0,curture[left]);
            res+=addleft+max_diff(curture,right,left+1,seats,seatslen+1,dp);
            seats.remove(0);
        }
        else{
            seats.add(0,curture[right-1]);
            res+=addleft+max_diff(curture,right-1,left,seats,seatslen+1,dp);
            seats.remove(0);
        }
        if (addright==addleft2righ){
            seats.add(curture[left]);
            res=Math.max(res,addright+max_diff(curture,right,left+1,seats,seatslen+1,dp));
        }else {
            seats.add(curture[right-1]);
            res=Math.max(res,addright+max_diff(curture,right-1,left,seats,seatslen+1,dp));
        }
        seats.remove(seatslen);
        dp[left][right]=res;
        return res;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int cases=scanner.nextInt();
        int[] cuture=new int[cases];
        int[][] dp=new int[cases][cases];
        for (int pos=0;pos<cases;pos++)
            cuture[pos]=scanner.nextInt();
        Arrays.sort(cuture);
        List<Integer> mylist=new ArrayList<>();
        mylist.add(cuture[cases-1]);
        Ali_0415_gjjl ali=new Ali_0415_gjjl();
        System.out.println(ali.max_diff(cuture,cases-1,0,mylist,1,dp));
    }
}
