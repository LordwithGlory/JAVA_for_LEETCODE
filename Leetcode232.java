import java.util.Stack;

public class Leetcode232 {
    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Leetcode232() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (!stack2.isEmpty()){
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty()&&stack1.isEmpty();
    }
}
