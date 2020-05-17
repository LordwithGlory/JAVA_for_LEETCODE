import java.util.ArrayList;
import java.util.List;

public class Weekly_5414 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // 有问题不是其他所有的 而是其他某个的一部分
//        List<Integer> res=new ArrayList<>();
//        Map<String,Integer> wanted_jobs=new HashMap<>();
//        for (List<String> onelist:favoriteCompanies){
//            for (String one:onelist)
//                wanted_jobs.put(one,wanted_jobs.getOrDefault(one,0)+1);
//        }
//        for (int pos=0;pos<favoriteCompanies.size();pos++){
//            boolean onlyu=false;
//            for (String one:favoriteCompanies.get(pos)){
//                if (wanted_jobs.get(one)==1){
//                    onlyu=true;
//                    break;
//                }
//            }
//            if (onlyu)
//                res.add(pos);
//        }
//        return res;
        // 果然是因为超过了int的最大值
        int[] favoritenum=new int[favoriteCompanies.size()];
        List<Integer> res=new ArrayList<>();
        List<String> allcompany=new ArrayList<>();
        for (int pos=0;pos<favoriteCompanies.size();pos++){
            int mynum=0;
            for (String company:favoriteCompanies.get(pos)){
                if (!allcompany.contains(company))
                    allcompany.add(company);
                int index=allcompany.indexOf(company);
                mynum|=(1<<index);
            }
            favoritenum[pos]=mynum;
        }
        for (int pos=0;pos<favoriteCompanies.size();pos++){
            boolean notson=false;
            int mynum=favoritenum[pos];
            for (int mypos=0;mypos<favoritenum.length&&!notson;mypos++){
                if (mypos==pos)
                    continue;
                int othernum=favoritenum[mypos]&mynum;
                if (othernum==mynum)
                    notson=true;
            }
            if (!notson)
                res.add(pos);
        }
        return res;
    }
}
