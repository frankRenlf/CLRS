package leetcode.stage2;

import leetcode.algorithm.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/30 13:25
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day7 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            return new TreeNode(val, root, null);
        }
        TreeNode par = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                par = cur;
                cur = cur.right;
            } else {
                par.right = new TreeNode(val, cur, null);
                return root;
            }
        }
        par.right = new TreeNode(val);
        return root;
    }

}
