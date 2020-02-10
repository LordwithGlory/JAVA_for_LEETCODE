import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    // 最快的是设置了全局变量
    // 第二快的那个传参中包含了自己的list，显而比我这个容易
    public List<List<Integer>> dfs(int n,int hasviewdone,int k){
        List<List<Integer>> nowres=new ArrayList<List<Integer>>();
        if (k==0){
           return null;
       }else if (hasviewdone+k>n){
           return null;
       }else if (k==1){
            for (int i=hasviewdone+1;i<=n;i++){
                List<Integer> oneres=new ArrayList<Integer>();
                oneres.add(i);
                nowres.add(oneres);
            }
            return nowres;
       }
       for (int i=hasviewdone+1;i<=n-k+1;i++){
           List<List<Integer>> oneres=dfs(n,i,k-1);
           if (oneres==null)
               break;
           for (List<Integer> onelist:oneres){
               onelist.add(0,i);
               nowres.add(onelist);
           }
       }
       return nowres;
    }
    public List<List<Integer>> combine(int n, int k) {
        return dfs(n,0,k);
    }
}
