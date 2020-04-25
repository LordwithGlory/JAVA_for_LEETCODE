import java.util.*;

public class Weekly_1419 {
    public int minNumberFrogs(String croakOfFrogs){
        int res=0;
        String sound="croak";
        List<Integer>[] poses=new ArrayList[5];
        for (int pos=0;pos<croakOfFrogs.length();pos++){
            char c=croakOfFrogs.charAt(pos);
            int sound_index=sound.indexOf(c);
            if (sound_index==-1)
                return -1;
            if (poses[sound_index]==null)
                poses[sound_index]=new ArrayList<>();
            poses[sound_index].add(pos);
            if (sound_index!=0){
                if (poses[sound_index-1]==null||poses[sound_index].size()>poses[sound_index-1].size())
                    return -1;
                if (sound_index==4){
                    res=Math.max(res,poses[0].size());
                    poses[0].remove(0);
                    poses[1].remove(0);
                    poses[2].remove(0);
                    poses[3].remove(0);
                    poses[4].remove(0);
                }
            }
        }
        for (List<Integer> one:poses){
            if (one.size()>0)
                return -1;
        }
        return res;
//        int len=poses[0].size();
//        for (int pos=1;pos<5;pos++){
//            if (poses[pos].size()!=len)
//                return -1;
//        }
//        while (poses[0].size()>0){
//            int fpos=poses[0].remove(0);
//            for (int pos=1;pos<5;pos++){
//                int tmppos=poses[pos].remove(0);
//                if (tmppos<fpos)
//                    return -1;
//                fpos=tmppos;
//            }
//            int toget=1;
//            for (int pos:poses[0]){
//                if (pos>fpos)
//                    break;
//                toget++;
//            }
//            res=Math.max(res,toget);
//        }
//        return res;
    }
    public int minNumberOfFrogs(String croakOfFrogs) {
        // 这个是考虑的每次只能听到一个声音 部分声音被忽略
        String sound="croak";
        int res=0;
        Set<Character>[] mayone=new HashSet[croakOfFrogs.length()];
        for (int pos=0;pos<croakOfFrogs.length();pos++)
            mayone[pos]=new HashSet<>();
        for (int pos=0;pos<croakOfFrogs.length();pos++){
            char crock=croakOfFrogs.charAt(pos);
            int soundindex=sound.indexOf(crock);
            if (soundindex==-1)
                return -1;
            int beginpos=pos-soundindex;
            if (beginpos<0)
                return -1;
            for (int add=0;add<5;add++){
                if (beginpos>croakOfFrogs.length())
                    return -1;
                mayone[beginpos].add(sound.charAt(add));
                beginpos++;
            }
        }
        for (Set<Character> one:mayone)
            res= Math.max(res,one.size());
        return res;
    }
}
