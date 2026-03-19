package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Caius
 * @description Lc 150 逆波兰表达式求值
 *
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 *
 * @since Created in 2026-03-19
 */
public class Lc150 {
    private static String[] tokens = {"2","1","+","3","*"};

    public static int evalRPN(String[] tokens){
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens) {
            if("+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        int ans = evalRPN(tokens);
        System.out.println(ans);
    }
}
