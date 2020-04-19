public class Weekly_5388 {
    public String reformat(String s) {
        String digitals="";
        String charters="";
        for (int pos=0;pos<s.length();pos++){
            char c=s.charAt(pos);
            if (c<='9'&&c>='0')
                digitals+=c;
            else
                charters+=c;
        }
        String res="";
        if (Math.abs(digitals.length()-charters.length())>1)
            return res;
        int myturn=0;
        if (digitals.length()<charters.length())
            myturn=1;
        int dpos=0;
        int cpos=0;
        while (dpos<digitals.length()||cpos<charters.length()){
            if (myturn==0)
                res+=digitals.charAt(dpos++);
            else
                res+=charters.charAt(cpos++);
            myturn++;
            myturn%=2;
        }
        return res;
    }
}
