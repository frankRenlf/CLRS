package leetcode.dailyWork;

import leetcode.algorithm.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/30 22:08
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l2End = list2;
        while (l2End.next != null) {
            l2End = l2End.next;
        }
        ListNode l1Pre = list1;
        for (int i = 0; i < a - 1; i++) {
            l1Pre = l1Pre.next;
        }
        ListNode l1End = l1Pre;
        for (int i = 0; i < b - a + 2; i++) {
            l1End = l1End.next;
        }
        l1Pre.next = list2;
        l2End.next = l1End;
        return list1;
    }
}
