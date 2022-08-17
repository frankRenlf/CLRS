package leetcode;


import leetcode.algorithm.Node;
import leetcode.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/17 13:38
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day8 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
        }
        return sum;
    }

    // 两种方法都可以,dfs和bfs需要计算的步骤和时间复杂度其实是一样的,那为什么消耗的时间差别这么多呢
    // 因为dfs只是简单计算, 而bfs借助了有一种数据结构,queue,这个种结构再放入拿出数据时会消耗一定的计算量, 导致了时间差
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        mergeTrees_bfs(root1, root2);
        mergeTrees_dfs(root1, root2);
        return root1 == null ? root2 : root1;
    }

    private void mergeTrees_bfs(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return;
        } else if (root2 == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode cur1 = queue.poll();
            TreeNode cur2 = queue.poll();
            cur1.val += cur2.val;
            if (cur1.left != null && cur2.left != null) {
                queue.offer(cur1.left);
                queue.offer(cur2.left);
            } else {
                cur1.left = cur1.left == null ? cur2.left : cur1.left;
            }
            if (cur1.right != null && cur2.right != null) {
                queue.offer(cur1.right);
                queue.offer(cur2.right);
            } else {
                cur1.right = cur1.right == null ? cur2.right : cur1.right;
            }
        }
    }

    private TreeNode mergeTrees_dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees_dfs(root1.left, root2.left);
        root1.right = mergeTrees_dfs(root1.right, root2.right);
        return root1;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = queue.poll();
            if (pre.left != null) {
                queue.offer(pre.left);
            }
            if (pre.right != null) {
                queue.offer(pre.right);
            }
            while (size > 1) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                pre.next = cur;
                pre = cur;
                size--;
            }
        }
        return root;
    }

}
