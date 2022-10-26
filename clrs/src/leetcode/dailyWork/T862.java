package leetcode.dailyWork;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/26 11:44
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T862 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }

}
