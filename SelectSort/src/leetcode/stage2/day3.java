package leetcode.stage2;

import leetcode.algorithm.ListNode;
import leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ret;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ret.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ret;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.push(t.charAt(i));
            }
        }
        if (s1.size() != s2.size()) return false;
        while (s1.size() != 0) {
            if (s1.pop() != s2.pop()) return false;
        }
        return true;
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int end1 = firstList.length, end2 = secondList.length;
        int s1 = 0, s2 = 0;
        List<int[]> ret = new ArrayList<>();
        while (s1 < end1 && s2 < end2) {
            int left = Math.max(firstList[s1][0], secondList[s2][0]);
            int right = Math.min(firstList[s1][1], secondList[s2][1]);
            if (left <= right) {
                ret.add(new int[]{left, right});
            }
            if (firstList[s1][1] < secondList[s2][1]) {
                s1++;
            } else {
                s2++;
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            max = Math.max(max, high * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        day3 d3 = new day3();
        System.out.println(d3.backspaceCompare("ab#c", "ad#c"));
    }

}
