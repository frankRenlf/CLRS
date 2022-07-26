package leetcode.dailyWork;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/5 15:56
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1106 {

    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<Character>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else {
                        f++;
                    }
                }
                stack.pop();
                char op = stack.pop();
                switch (op) {
                    case '!' -> stack.push(f == 1 ? 't' : 'f');
                    case '&' -> stack.push(f == 0 ? 't' : 'f');
                    case '|' -> stack.push(t > 0 ? 't' : 'f');
                    default -> {
                    }
                }
            }
        }
        return stack.pop() == 't';
    }

}
