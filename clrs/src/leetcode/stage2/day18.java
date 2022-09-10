package leetcode.stage2;

import leetcode.algorithm.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/10 10:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day18 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

    public TreeNode trimBST_bfs(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            root = root.val < low ? root.right : root.left;
        }
        if (root == null) return null;
        TreeNode cur = root;
        while (cur.left != null) {
            if (cur.left.val < low) {
                cur.left = cur.left.right;
            } else {
                cur = cur.left;
            }
        }
        cur = root;
        while (cur.right != null) {
            if (cur.right.val > high) {
                cur.right = cur.right.left;
            } else {
                cur = cur.right;
            }
        }
        return root;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int countZero = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            countZero++;
        }
        return m << countZero;
    }

}
