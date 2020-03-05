import java.util.*;

public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 1;
        if (!wordList.contains(endWord))
            return 0;
        Queue<String> q=new LinkedList<String>();
        Map<String,Integer> indexmap=new HashMap<String, Integer>();
        if (wordList.contains(beginWord))
            wordList.remove(beginWord);
        Set<String> wordset=new HashSet<>();
        indexmap.put(beginWord,1);
        q.add(beginWord);
        int wordlen=beginWord.length();
        while (!q.isEmpty()){
            String head=q.poll();
            int thefloor=indexmap.get(head);
            char[] word=head.toCharArray();
            for (int pos=0;pos<wordlen;pos++){
                char tmpc=word[pos];
                for (char c='a';c<='z';c++){
                    if (c==tmpc)
                        continue;
                    word[pos]=c;
                    String tmps=new String(word);
                    if (!wordset.contains(tmps)||indexmap.containsKey(tmps))
                        continue;
                    wordset.remove(tmps);
                    q.add(tmps);
                    indexmap.put(tmps,thefloor+1);
                    if (tmps.equals(endWord))
                        return indexmap.get(endWord);
                }
                word[pos]=tmpc;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        String beginword=new String("hit");
        String endword=new String("cog");
        List<String> wordlist=new ArrayList<>();
        wordlist.add("hot");
        wordlist.add("dot");
        wordlist.add("dog");
        wordlist.add("lot");
        wordlist.add("log");
        wordlist.add("cog");
        Leetcode127 lc=new Leetcode127();
        System.out.println(lc.ladderLength(beginword,endword,wordlist));
    }
}
