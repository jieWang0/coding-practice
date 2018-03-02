package stackandqueue;

import java.util.Stack;

public class GetMinStack{

    static class MinStack<T> extends Stack<T>{

        Stack<T> innerStack = new Stack<>();

        @Override
        public synchronized T pop() {
            T index = super.pop();
            if(!innerStack.isEmpty() && (int)innerStack.peek()==(int)index) {
                innerStack.pop();
            }
            return index;
        }

        @Override
        public T push(T item) {
            if(innerStack.isEmpty() || (int)innerStack.peek()>=(int)item) {
                innerStack.push(item);
            }
            return super.push(item);
        }

        public T getMin() {
            return innerStack.peek();
        }
    }


    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.push(0);
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
