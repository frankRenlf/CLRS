package leetcode.dailyWork;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/21 16:39
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
class KthLargest {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int n :
                nums) {
            add(n);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}

public class T703 {
}
