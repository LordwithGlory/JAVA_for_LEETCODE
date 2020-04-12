import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_weekly_5383 {
    public int nextfoor(int n,int nowfloor,List<Integer>[] conused,Map<String,Integer> myway,String[] floorcolor,int formerclor){
        int res=0;
        if (nowfloor==n)
            return 1;
        for (int nowcolor:conused[formerclor]){
            String key=Integer.toString(nowfloor+1)+floorcolor[nowcolor];
            if (!myway.containsKey(key))
                nextfoor(n,nowfloor+1,conused,myway,floorcolor,nowcolor);
            res+=myway.get(key);
            res%=1000000007;
        }
        res%=1000000007;
        myway.put(Integer.toString(nowfloor)+floorcolor[formerclor],res);
        return res;
    }
    public int numOfWays(int n) {
        if (n==0)
            return 0;
        List<Integer> conused[]=new ArrayList[12];
        String[] colors=new String[12];
        Map<String,Integer> myway=new HashMap<>();
        int colorpos=0;
        for (int color_1=0;color_1<3;color_1++){
            for (int color_2=0;color_2<3;color_2++){
                if (color_2==color_1)
                    continue;
                for (int color_3=0;color_3<3;color_3++){
                    if (color_2==color_3)
                        continue;
                    colors[colorpos]=Integer.toString(color_1)+Integer.toString(color_2)+Integer.toString(color_3);
                    colorpos++;
                    in
                }
            }
        }
        for (colorpos=0;colorpos<12;colorpos++){
            String abovecolor=colors[colorpos];
            conused[colorpos]=new ArrayList<>();
            for (int next=0;next<12;next++){
                String nextcolor=colors[next];
                if (abovecolor.charAt(0)==nextcolor.charAt(0)||abovecolor.charAt(1)==nextcolor.charAt(1)||abovecolor.charAt(2)==nextcolor.charAt(2))
                    continue;
                conused[colorpos].add(next);
            }
        }
        int res=0;
        for (int i=0;i<12;i++){
            res+=nextfoor(n,1,conused,myway,colors,i);
        }
        return res;
    }
}
