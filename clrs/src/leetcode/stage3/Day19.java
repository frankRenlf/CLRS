package leetcode.stage3;

import leetcode.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/29 8:11
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day19 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(0),new TreeNode(4)),new TreeNode(3));

        day19.inorder(root);
    }

    public void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
//            --k;
//            if (k == 0) {
//                break;
//            }
            root = root.right;
        }
        return root.val;
    }

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        findNode(root, queue);
        while (!queue.isEmpty() && k > 1) {
            queue.poll();
        }
        return queue.poll();
    }

    private void findNode(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) return;
        queue.add(root.val);
        findNode(root.left, queue);
        findNode(root.right, queue);
    }

    public int countNodes(TreeNode root) {
        return calNode(root);
    }

    private int calNode(TreeNode root) {
        if (root == null) return 0;
        int cnt = 0;
        cnt += calNode(root.left) + calNode(root.right) + 1;
        return cnt;
    }


    public boolean isFlipedString(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 != l2) return false;
        String s3 = s2 + s2;
        return s3.contains(s1);
    }

    static Day19 day19 = new Day19();

    public static void main1(String[] args) {
        System.out.println(day19.isFlipedString("waterbottle",
                "erbottlewat"));
    }

}
