import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode126_c {
    Map<String, List<String>> fmap=new HashMap<String, List<String>>();
    Map<String, Integer> distance=new HashMap<String, Integer>();
    public void bfs(String endword,List<String> content,List<String> wordlist){
        distance.put(content.get(0),1);
        while (!content.isEmpty()){
            String former=content.remove(0);
            if (former.equals(endword))
                break;
            // 保证不会多次查询后续的节点
            wordlist.remove(former);
            char[] formerc=former.toCharArray();
            int index=distance.get(former);
            if (distance.containsKey(endword)&&distance.get(endword)<index+1)
                break;
            for (int pos=0;pos<former.length();pos++){
//                char tmpc=former.charAt(pos);
                char tmpc=formerc[pos];
                for (char c='a';c<='z';c++){
                    if (c==tmpc)
                        continue;
                    formerc[pos]=c;
                    String nextword=new String(formerc);
                    if (!wordlist.contains(nextword)||distance.containsKey(nextword)&&distance.get(nextword)<index+1)
                        continue;
                    distance.put(nextword,index+1);
                    if (!fmap.containsKey(nextword))
                        fmap.put(nextword,new ArrayList<String>());
                    if (fmap.get(nextword).contains(former))
                        continue;
                    fmap.get(nextword).add(former);
                    content.add(nextword);
                    if (nextword.equals(endword))
                        break;
                }
                formerc[pos]=tmpc;
            }
        }
    }
    public void findpath(String endword,String beginword,List<String> oneres,List<List<String>> res,int depth){
        if (depth!=distance.get(endword))
            return;
        if (beginword.equals(endword)){
            res.add(new ArrayList<String>(oneres));
            return;
        }
        if (!fmap.containsKey(endword))
            return;
        for (String formerword:fmap.get(endword)){
            if (oneres.contains(formerword))
                continue;
            oneres.add(0,formerword);
            findpath(formerword,beginword,oneres,res,depth-1);
            oneres.remove(0);
            if (formerword.equals(beginword))
                return;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res=new ArrayList<List<String>>();
        if (!wordList.contains(endWord))
            return res;
        List<String> content=new ArrayList<>();
//        List<String> wl_copy=new ArrayList<String>(wordList);
        if (beginWord.equals(endWord)){
            content.add(endWord);
            res.add(content);
            return res;
        }
        content.add(beginWord);
        bfs(endWord,content,wordList);
        content.clear();
        content.add(endWord);
        if (!distance.containsKey(endWord))
            return res;
        findpath(endWord,beginWord,content,res,distance.get(endWord));
        return res;
    }

    public static void main(String[] args){
        Leetcode126_c lc=new Leetcode126_c();
        List<String> wordlist=new ArrayList<String>();
        wordlist.add("hot");
        wordlist.add("dot");
        wordlist.add("dog");
        wordlist.add("lot");
        wordlist.add("log");
        wordlist.add("cog");
        lc.findLadders("hit","cog",wordlist);
        System.out.println(lc.distance);
    }
}
