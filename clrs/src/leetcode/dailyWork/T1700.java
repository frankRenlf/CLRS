package leetcode.dailyWork;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/19 11:03
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int n = students.length;
        for (int student : students) {
            queue.offer(student);
        }
        for (int i = 0; i < n; i++) {
            int size = queue.size();
            while (size > 0 && queue.peek() != sandwiches[i]) {
                int top = queue.poll();
                queue.offer(top);
                size--;
            }
            if (size == 0) break;
            queue.poll();
        }
        return queue.size();
    }

    static T1700 t1700 = new T1700();

    public static void main(String[] args) {
        System.out.println(t1700.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

}
