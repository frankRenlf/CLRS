package leetcode.dailyWork;

import leetcode.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/12 11:43
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T817 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        boolean continuity = false;
        int ret = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!continuity) {
                    continuity = true;
                    ret++;
                }
            } else {
                continuity = false;
            }
            head = head.next;
        }
        return ret;
    }

}
