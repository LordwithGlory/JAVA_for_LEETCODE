import java.util.*;

public class Leetcode126 {
//    public void findPath(String beginword,String endword,List<String> wordlist,List<String> oneres,List<List<String>> res){
//        // 没想到中间还可以进行变换。。。
//        oneres.add(endword);
//        if (beginword.equals(endword)){
//            res.add(new ArrayList<String>(oneres));
//            return;
//        }
//        int wlen=beginword.length();
//        for (int pos=0;pos<wlen;pos++){
//            if (beginword.charAt(pos)==endword.charAt(pos)){
//                continue;
//            }
//            String nextbegin=beginword.substring(0,pos)+endword.charAt(pos)+beginword.substring(pos+1,beginword.length());
//            System.out.println(nextbegin);
//            if (wordlist.contains(nextbegin)){
//                findPath(nextbegin,endword,wordlist,oneres,res);
//            }
//        }
//        oneres.remove(oneres.size()-1);
//        return;
//    }
    public void findpath(String beginword,String endword,List<List<String>> res,List<String> oneres,int depth,List<String> wordlist,boolean[] hasviewed){
        if (depth>maxdepth)
            return;
        if (beginword.equals(endword)){
            if (maxdepth>depth){
                res.clear();
                maxdepth=depth;
            }
            res.add(new ArrayList<String>(oneres));
            return;
        }
        int llen=beginword.length();
        for (int i=0;i<wordlist.size();i++){
            if (hasviewed[i])
                continue;
            int dcount=0;
            String tmpstr=wordlist.get(i);
            for (int pos=0;pos<llen&&dcount<2;pos++){
                if (beginword.charAt(pos)==tmpstr.charAt(pos))
                    continue;
                dcount++;
            }
            if (dcount==1){
                hasviewed[i]=true;
                oneres.add(tmpstr);
                findpath(tmpstr,endword,res,oneres,depth+1,wordlist,hasviewed);
                hasviewed[i]=false;
                oneres.remove(tmpstr);
                if (tmpstr.equals(endword))
                    break;
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> oneres=new ArrayList<String>();
        List<List<String>> res=new ArrayList<List<String>>();
        if (!wordList.contains(endWord))
            return res;
        if (endWord.length()!=beginWord.length())
            return res;
        oneres.add(beginWord);
        if (beginWord.equals(endWord)){
            res.add(oneres);
            return res;
        }
        maxdepth=wordList.size()+1;
        boolean[] hasviewed=new boolean[wordList.size()];
        if (wordList.indexOf(beginWord)!=-1){
            hasviewed[wordList.indexOf(beginWord)]=true;
            maxdepth--;
        }
        findpath(beginWord,endWord,res,oneres,1,wordList,hasviewed);
//        findPath(beginWord,endWord,wordList,oneres,res);
        System.out.println(res);
        return res;
    }
    int maxdepth;
    Map<String,List<String>> smap=new HashMap<String, List<String>>();
    public void bfs(List<String> wordlist,List<String> need2View,String endword,int nlen){
        boolean wanttoadd=true;
        while (need2View.size()>0){
            if (nlen==0){
                maxdepth+=1;
                nlen=need2View.size();
            }
            String word=need2View.remove(0);
            nlen--;
            List<String> wlist=new ArrayList<String>();
            if (smap.containsKey(word))
                continue;
            for (int pos=0;pos<word.length();pos++){
                char tmp=word.charAt(pos);
                for (char c='a';c<='z';c++){
                    if (c==tmp)
                        continue;
                    String tmpstr=word.substring(0,pos)+c+word.substring(pos+1);
                    if (!wordlist.contains(tmpstr)||smap.containsKey(tmpstr))
                        continue;
                    wlist.add(tmpstr);
                    if (wanttoadd)
                        need2View.add(tmpstr);
                    if (tmpstr.equals(endword)){
                        wanttoadd=false;
                        break;
                    }
                }
            }
//            for (String one:wordlist){
//                // 这个是遍历所有的word
//                if (smap.containsKey(one)||one.equals(word))
//                    continue;
//                int count=0;
//                for (int pos=0;pos<one.length()&&count<2;pos++){
//                    if (one.charAt(pos)==word.charAt(pos))
//                        continue;
//                    count++;
//                }
//                if (count==1){
//                    wlist.add(one);
//                    if (wanttoadd)
//                        need2View.add(one);
//                    if (one.equals(endword))
//                        wanttoadd=false;
//                }
//            }
            smap.put(word,new ArrayList<>(wlist));
        }
    }
    public void findthePath(String beginword,String endword,List<String> oneres,List<List<String>> res,int depth){
        if (depth>maxdepth)
            return;
        if (beginword.equals(endword)){
            if (depth<maxdepth){
                maxdepth=depth;
                res.clear();
            }
            res.add(new ArrayList<>(oneres));
            return;
        }
        if (!smap.containsKey(beginword))
            return;
        for (String word:smap.get(beginword)){
            if (oneres.contains(word))
                continue;
            oneres.add(word);
            findthePath(word,endword,oneres,res,depth+1);
            oneres.remove(word);
        }
    }
    public void findmypath(String endword,String beginword,int depth,List<List<String>> res,List<String> oneres){
        if (depth>maxdepth)
            return;
        if (endword.equals(beginword)){
            if (depth<maxdepth){
                maxdepth=depth;
                res.clear();
            }
            res.add(new ArrayList<>(new ArrayList<>(oneres)));
            return;
        }
        for (String key:smap.keySet()){
            if (oneres.contains(key))
                continue;
            if (smap.get(key).contains(endword)){
                oneres.add(0,key);
                findmypath(key,beginword,depth+1,res,oneres);
                oneres.remove(0);
            }
        }
    }
    public List<List<String>> findLadder(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res=new ArrayList<List<String>>();
        if (!wordList.contains(endWord))
            return res;
        if (endWord.length()!=beginWord.length())
            return res;
        List<String> con=new ArrayList<>();
        maxdepth=1;
        con.add(beginWord);
        bfs(wordList,con,endWord,1);
        con.clear();
        con.add(endWord);
        findmypath(endWord,beginWord,1,res,con);
//        con.add(beginWord);
//        findthePath(beginWord,endWord,con,res,1);
        System.out.println(res);
        return res;
    }
    public static void main(String[] args){
        Leetcode126 lc=new Leetcode126();
        List<String> wordlist=new ArrayList<String>();
        wordlist.add("hot");
        wordlist.add("dot");
        wordlist.add("dog");
        wordlist.add("lot");
        wordlist.add("log");
        wordlist.add("cog");
        lc.findLadder("hit","cog",wordlist);
    }
}
