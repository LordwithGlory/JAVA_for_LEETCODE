import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode155 {
    // 最快的用的是链表有点意思鸭
    Stack<Integer> stone=new Stack<>();
    Stack<Integer> sttwo=new Stack<>();
    public Leetcode155() {
        // 一个用来存最小的那个
    }

    public void push(int x) {
        if (stone.isEmpty()||stone.get(0)<x)
            stone.add(x);
        else {
            while (!stone.isEmpty())
                sttwo.add(0,stone.remove(0));
            stone.push(x);
        }
    }

    public void pop() {
        stone.pop();
        if (stone.isEmpty()&&!sttwo.isEmpty()){
            int minpos=0;
            for (int pos=1;pos<sttwo.size();pos++){
                if (sttwo.get(pos)<sttwo.get(minpos))
                    minpos=pos;
            }
            for (int pos=0;pos<=minpos;pos++)
                stone.add(0,sttwo.remove(0));
        }
    }

    public int top() {
        return stone.peek();
    }

    public int getMin() {
        return stone.get(0);
    }
}
