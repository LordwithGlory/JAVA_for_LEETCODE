public class Leetcode23 {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode(-1);
        ListNode tmpres=res;
        boolean is_over=false;
        if(lists.length==0){
            // 不加这个的话当输入当lists是空当时候报错
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        while (!is_over||res.next==null){
            // 完全是多路归并==
            // 但是好像看他们二路归并速度更快一些
            // 递归加二路归并，速度不止快一些那样
            // 疯狂表示mmp
            int minnode=0;
            is_over=true;
            for(int i=1;i<lists.length;i++){
                if(lists[i]==null){
                    continue;
                }
                is_over=false;
                if(lists[minnode]==null){
                    minnode=i;
                    continue;
                }
                if(lists[i].val<lists[minnode].val){
                    // 这个当时错了一下因为是
                    minnode=i;
                }
            }
            if(lists[minnode]!=null){
                // 当最小的不是null 时候
                tmpres.next=lists[minnode];
                tmpres=tmpres.next;
                lists[minnode]=lists[minnode].next;
            }else{
                break;
            }
        }
        return res.next;
    }

    public static void main(String argvs[]){
        // 每次都会因为难构造这些结构体数组而放弃主函数的编写

    }
}
