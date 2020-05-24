public class Weekly_5416 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int res=-1;
        int mylen=searchWord.length();
        String[] sen=sentence.split(" ");
        for (String one:sen)
            System.out.println(one);
        char[] wordchar=searchWord.toCharArray();
        for (int pos=0;pos<sen.length&&res!=-1;pos++){
            String tmpstr=sen[pos];
            if (tmpstr.length()<mylen)
                continue;
            tmpstr=tmpstr.substring(0,mylen);
            if (tmpstr.equals(searchWord)){
                res=pos+1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Weekly_5416 lc=new Weekly_5416();
        lc.isPrefixOfWord("i love eating burger","burg");
    }
}
