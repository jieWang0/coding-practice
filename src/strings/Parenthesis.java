package strings;

import java.util.*;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        if(n<2 || n%2==1) {
            return false;
        }
        Stack<Character> s = new Stack<>();
        char[] c = A.toCharArray();
        for(int i=0;i<c.length;i++) {
            if(c[i] == '(') {
                s.push('(');
            } else if(c[i] == ')') {
                if(s.isEmpty())
                    return false;
                s.pop();
            } else {
                return false;
            }
        }
        if(!s.isEmpty()) {
            return false;
        }
        return true;
    }
}
