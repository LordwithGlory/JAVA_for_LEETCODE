public class Leetcode65 {
    public boolean isNumber(String s) {
        // trim方法可以去掉前后的空格
        // 最快的使用的是几个标记位置标记各个数字字符科学技术法出现的地方
        // 我写的真鸡儿xiang
        int lens=s.length();
        int beginpos=0;
        boolean science=false;
        boolean point=false;
        while (beginpos<lens&&s.charAt(beginpos)==' ')
            beginpos++;
        lens--;
        while (lens>=0&&s.charAt(lens)==' ')
            lens--;
        if (lens<beginpos)
            return false;
        s=s.substring(beginpos,lens+1);
        s=s.toLowerCase();
        int cut=s.indexOf("e");
        lens=s.length();
        if (cut==lens-1)
            return false;
        if (cut!=-1){
            // 判断科学技术法后面那部分的正确性
            String back=s.substring(cut+1,lens);
            int backlen=back.length();
            if (backlen==0)
                return false;
            for (int i=0;i<backlen;i++){
                char nowpos=back.charAt(i);
                if (i==0&&(nowpos=='+'||nowpos=='-')&&backlen!=1)
                    continue;
                if (nowpos>'9'||nowpos<'0')
                    return false;
            }
            s=s.substring(0,cut);
            science=true;
        }
        lens=s.length();
        if (lens==0)
            return false;
        for (int i=0;i<lens;i++){
            char nowpos=s.charAt(i);
            if (i==0&&(nowpos=='-'||nowpos=='+')&&lens!=1)
                continue;
            if (i==lens-1&&nowpos=='.'){
                if (lens==1||s.charAt(lens-2)>'9'||s.charAt(lens-2)<'0')
                    return false;
            }
            if (nowpos=='.'){
                if (point)
                    return false;
                point=true;
                continue;
            }
            if (nowpos<'0'||nowpos>'9')
                return false;

        }
        return true;
//        int lens=s.length();
//        int beginpos=0;
//        boolean point=false;
//        boolean sn=false;
//        boolean allchar=true;
//        // 防止两个连续的符号
//        boolean formerchar=false;
//        while (beginpos<lens&&s.charAt(beginpos)==' ')
//            beginpos++;
//        if (beginpos==lens)
//            return false;
//        if (s.charAt(beginpos)=='+'||s.charAt(beginpos)=='-'){
//            beginpos++;
//            formerchar=true;
//        }else if (s.charAt(beginpos)=='.'){
//            beginpos++;
//            point=true;
//            formerchar=true;
//        }else if (s.charAt(beginpos)>'9'||s.charAt(beginpos)<'0')
//            return false;
//        if (beginpos==lens)
//            return false;
//        for (;beginpos<lens;beginpos++){
//            char now=s.charAt(beginpos);
//            if (now==' '){
//                while (beginpos<lens&&s.charAt(beginpos)==' ')
//                    beginpos++;
//                if (beginpos!=lens)
//                    return false;
//                break;
//            }
//            if (now>='0'&&now<='9'){
//                allchar=false;
//                formerchar=false;
//                continue;
//            }
//            if (now=='.'){
//                if (!point&&!formerchar){
//                    point=true;
//                    formerchar=true;
//                    continue;
//                }else
//                    return false;
//            }
//            if (now=='e'||now=='E'){
//                if (!sn&&beginpos!=lens-1&&!formerchar){
//                    sn=true;
//                    formerchar=true;
//                    beginpos++;
//                    while (beginpos)
//                }else
//                    return false;
//            }
//            return false;
//        }
//        if (allchar)
//            return false;
//        return true;
    }
}
