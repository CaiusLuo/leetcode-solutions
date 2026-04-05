package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Caius
 * @description Lc295. 数据流的中位数
 *
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 *
 * @since Created in 2026-04-05
 */
public class MedianFinder {
    Queue<Integer> less;
    Queue<Integer> greater;
    public MedianFinder() {
        less = new PriorityQueue<>();
        greater = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if(less.size() != greater.size()) {
            less.offer(num);
            greater.offer(less.poll());
        } else {
            greater.offer(num);
            less.offer(greater.poll());
        }
    }

    public double findMedian() {
        return less.size() == greater.size() ? less.peek() : (less.peek() + greater.peek()) / 2.0;
    }
}
