import java.util.Stack;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        // 最快的用的是数组和一个top这个量没有使用stack n
        Stack<Integer> numbers=new Stack<>();
        for (String str:tokens){
            // 用hashset代替这个if else判断会更快
            if (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
                int num1=numbers.pop();
                int num2=numbers.pop();
                // switch其实还是很慢的。。。比if else慢
                switch (str){
                    case "+":
                        numbers.push(num1+num2);
                        break;
                    case "-":
                        numbers.push(num2-num1);
                        break;
                    case "*":
                        numbers.push(num1*num2);
                        break;
                    case "/":
                        numbers.push(num2/num1);
                }
                continue;
            }
            numbers.push(Integer.parseInt(str));
        }
        return numbers.pop();
    }
}
