package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Caius
 * @description Lc155 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 *
 * @since Created in 2026-03-19
 */
public class MiniStack {
    private Deque<Integer> minDeque;
    private Deque<Integer> dataDeque;
    public MiniStack(){
        minDeque = new ArrayDeque<>();
        dataDeque = new ArrayDeque<>();
    }

    public void push(int val) {
        dataDeque.push(val);
        if(minDeque.isEmpty() || val < minDeque.peek()) {
            minDeque.push(val);
        } else {
            minDeque.push(minDeque.peek());
        }
    }

    public void pop() {
        dataDeque.pop();
        minDeque.pop();
    }

    public int top() {
        return dataDeque.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }
    public static void main(String[] args) {

    }
}
