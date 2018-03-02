package stackandqueue;

import java.util.Stack;


public class ReverseStack {
    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        int index = getLast(stack);

        reverse(stack);
        stack.push(index);
    }

    public static int getLast(Stack<Integer> stack) {
        if(stack.size() ==1) {
            return stack.pop();
        }
        int index = stack.pop();
        int index2 = getLast(stack);
        stack.push(index);
        return index2;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        reverse(stack);
        System.out.println(stack.pop());
        for (int i:stack
             ) {
            System.out.println(i);
        }
    }
}
