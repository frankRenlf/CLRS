package leetcode.stage2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/31 10:35
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day8 {

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> s1 = new Stack<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            s1.push(pushed[i]);
            while (!s1.isEmpty() && s1.peek() == popped[j]) {
                s1.pop();
                j++;
            }
        }
        return s1.isEmpty();
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || popped.length == 0 || pushed.length == 0) return false;
        Stack<Integer> s1 = new Stack<>();
        int index_pushed = 1;
        int index_popped = 0;
        s1.push(pushed[0]);
        while (index_pushed < pushed.length) {
            if (s1.peek() != popped[index_popped]) {
                s1.push(pushed[index_pushed]);
                index_pushed++;
            } else {
                s1.pop();
                index_popped++;
            }
        }
        while (!s1.isEmpty() && s1.peek() == popped[index_popped]) {
            s1.pop();
            index_popped++;
        }
        return s1.isEmpty();
    }

}
