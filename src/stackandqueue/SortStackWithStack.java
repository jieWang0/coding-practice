package stackandqueue;

import java.util.Stack;

public class SortStackWithStack {

    public static void sort(Stack<Integer> stack,Stack<Integer> help) {

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if(help.isEmpty()) {
                help.push(cur);
            } else {
                if(cur>=help.peek()) {
                    help.push(cur);
                } else {
                    while (!help.isEmpty() &&cur<help.peek() )
                        stack.push(help.pop());
                    help.push(cur);
                }
            }

        }
        if(stack.isEmpty()) {
            while (!help.isEmpty()) {
                stack.push(help.pop());
            }
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        sort(stack,help);
        for (int a:stack
             ) {
            System.out.println(a);
        }
    }
}
