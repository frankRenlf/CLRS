package leetcode.stage2;

import leetcode.algorithm.ListNode;
import leetcode.algorithm.TreeNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/26 10:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day3 {

    public int maxProduct(int[] nums) {
        int first = nums[0], second = nums[1];
        if (first < second) {
            first = second;
            second = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if (cur.val == next.val) {
                next = next.next;
            } else {
                cur.next = next;
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode ret = new ListNode(0, head);
        ListNode pre = ret;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int value = pre.next.val;
                while (pre.next != null && pre.next.val == value) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return ret.next;
    }

}