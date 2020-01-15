public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        int maxlen=0;
        int lens=s.length();
        int i=lens-1;
        while (i>=0&&s.charAt(i)==' ')
            i--;
        for (;i>=0;i--){
            char now=s.charAt(i);
            if (now==' '){
                break;
            }
            maxlen++;
        }
        return maxlen;
//        s=s.toLowerCase();
//        boolean[] hasfound=new boolean[26];
//        int res=0;
//        int lens=s.length();
//        while (lens>0){
//            lens--;
//            char tmpcahr=s.charAt(lens);
//            if (tmpcahr==' ')
//                continue;
//            if (hasfound[tmpcahr-'a'])
//                continue;
//            hasfound[tmpcahr-'a']=true;
//            res++;
//        }
//        return res;
    }
}
