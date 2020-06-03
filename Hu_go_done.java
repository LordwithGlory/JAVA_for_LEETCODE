public class Hu_go_done {
    private char[] str60keys={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
    private static final int LEN_INT=8;
    private static final int LEN_MD5 = 32;
    private static final int LEN_POMS_1 = 36;
    private static final int LEN_POMS_2 = 88;
    private static final int LEN_POMS_3 = 56;

    private String ten_60(int ten){
        StringBuilder sb=new StringBuilder();
        while (ten!=0){
            int tmp=ten%60;
            sb.append(str60keys[tmp]);
            ten/=10;
        }
        return sb.reverse().toString();
    }

    private int six_10(String six){
        int n=1;
        int res=0;
        for (int pos=six.length()-1;pos>=0;pos--){
            char tmp=six.charAt(pos);
            int num=0;
            while (str60keys[num++]!=tmp);
            res+=n*num;
            n*=60;
        }
        return res;
    }

    private String assignString(int len,String str){
        int strlen=str.length();
        if (strlen<len){
            while (strlen<len){
                str+="0";
                strlen++;
            }
            return str;
        }
        if (strlen>len){
            int cut=strlen-len;
            return str.substring(cut,strlen);
        }
        return str;
    }

    private String convhexto60(String hex){
        int strlen=hex.length();
        int loop=strlen/8;
        if (strlen%8!=0)
            loop++;
        int assignlen=loop*8;
        String assignstr=this.assignString(assignlen,hex);
        String string="";
        String split="";
        int setp=0;
        for (int pos=0;pos<loop;pos++){
            int tmp=0;
            for (int bloop=0;bloop<4;bloop++){
                tmp<<=4;
                tmp+=Integer.valueOf(assignstr.substring(setp,setp+2),16);
                setp+=2;
            }
            string+=split+ tmp;
            split="-";
        }
        return string;
    }

    private String conv60tohex(String strint){
        int len=strint.length();
        String res="";
        for (int pos=0;pos<len;pos++){
            if (strint.charAt(pos)=='-')
                continue;
            char c=strint.charAt(pos);
            int ten=six_10(c+" ");
            String hex=Integer.toString(ten,16);
            hex=hex.substring(2);
            res+=this.assignString(LEN_INT,hex);
        }
        return res;
    }

    private String encodeFileKey(String flag,String key){
        String res=this.convhexto60(key);
        res=res.replace('-','I');
        return flag+'-'+res.replace('/','U');
    }

    private String decodeFileKey(String filekey){
        int thepos=filekey.indexOf('-');
        String flag=filekey.substring(0,thepos);
        String key=filekey.substring(thepos+1);
        key=key.replace('I','-');
        key=key.replace('U','/');
        int assignlen=0;
        if (flag.equals("C"))
            assignlen=this.LEN_POMS_1;
        else if (flag.equals("E"))
            assignlen=this.LEN_POMS_3;
        else
            return "";
        return assignString(assignlen,conv60tohex(key));
    }
}
