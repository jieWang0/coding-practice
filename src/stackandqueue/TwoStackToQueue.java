package stackandqueue;

import java.util.Stack;

public class TwoStackToQueue<T> {
    private Stack<T> first = new Stack<>();
    private Stack<T> second = new Stack<>();

    public T add(T item) {
        return first.push(item);
    }

    public synchronized T take() {
        if(!second.isEmpty()) {
            return second.pop();
        }
        if(!first.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            return second.pop();
        }
        return second.pop();
    }


    public static void main(String[] args) {
        TwoStackToQueue<Integer> twoStackToQueue = new TwoStackToQueue<>();
        twoStackToQueue.add(1);
        twoStackToQueue.add(2);
        twoStackToQueue.add(3);
        System.out.println(twoStackToQueue.take());
        twoStackToQueue.add(4);
        System.out.println(twoStackToQueue.take());
        twoStackToQueue.add(5);
        System.out.println(twoStackToQueue.take());

    }
}
