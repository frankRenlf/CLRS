package leetcode.stage3;

import leetcode.algorithm.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/22 21:20
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day13 {

    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null || node == null) {
            return false;
        }
        stack.push(root);
        if (root == node) {
            return true;
        }
        boolean key = getPath(root.left, node, stack);
        if (key) {
            return true;
        }
        key = getPath(root.right, node, stack);
        if (key) {
            return true;
        }
        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root, p, stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root, q, stack2);
        int diff = stack1.size() - stack2.size();
        while (diff > 0) {
            diff--;
            stack1.pop();
        }
        while (diff < 0) {
            diff++;
            stack2.pop();
        }
        while (stack1.size() > 0) {
            TreeNode cur = stack1.pop();
            if (Objects.equals(cur, stack2.pop())) {
                return cur;
            }
        }
        return null;
    }

}
