import java.util.Stack;

public class Weekly_5430 {
    private  Stack<String> hasviewd=new Stack<>();
    private  Stack<String> backviewd=new Stack<>();
    public Weekly_5430(String homepage) {
        this.hasviewd.add(homepage);
    }

    public void visit(String url) {
        this.hasviewd.add(url);
        if (!this.backviewd.isEmpty())
            this.backviewd.clear();
    }

    public String back(int steps) {
        while (steps>0||this.hasviewd.size()>1){
            this.backviewd.add(this.hasviewd.pop());
            steps--;
        }
        return this.hasviewd.peek();
    }

    public String forward(int steps) {
        while (steps>0&&this.backviewd.size()>0){
            this.hasviewd.add(this.backviewd.pop());
            steps--;
        }
        return this.hasviewd.peek();
    }

    public static void main(String[] args){
        Weekly_5430 w=new Weekly_5430("baidu");
        w.visit("tianmao");
        w.visit("tab");
        System.out.println(w.back(2));
        System.out.println(w.forward(3));
    }
}
