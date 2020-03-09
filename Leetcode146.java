public class Leetcode146 {
    class LRUCache {
        // 最快的自己建立了双向连标和map
        int[] usedtime;
        int[] keys;
        int[] vals;
        int inserttime;
        public LRUCache(int capacity) {
            usedtime=new int[capacity];
            keys=new int[capacity];
            vals=new int[capacity];
            inserttime=0;
        }

        public int get(int key) {
            for (int pos=0;pos<keys.length;pos++){
                if (keys[pos]==key&&usedtime[pos]!=0){
                    inserttime++;
                    usedtime[pos]=inserttime;
                    return vals[pos];
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            inserttime++;
            int minpos=0;
            for (int pos=0;pos<keys.length;pos++){
                if (usedtime[pos]==0){
                    usedtime[pos]=inserttime;
                    keys[pos]=key;
                    vals[pos]=value;
                    return;
                }
                if (usedtime[pos]<usedtime[minpos])
                    minpos=pos;
                if (keys[pos]==key){
                    vals[pos]=value;
                    usedtime[pos]=inserttime;
                    return;
                }
            }
            usedtime[minpos]=inserttime;
            keys[minpos]=key;
            vals[minpos]=value;
        }
    }
}
