package leetcode.dailyWork;

import leetcode.algorithm.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/6 17:59
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2331 {

    public boolean evaluateTree(TreeNode root) {
        Boolean ret = null;
        if (root.left == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            ret = evaluateTree(root.left) || evaluateTree(root.right);
        } else if (root.val == 3) {
            ret = evaluateTree(root.left) && evaluateTree(root.right);
        } else {
            return root.val == 1;
        }
        return ret;
    }

    static T2331 t2331 = new T2331();

    public static void main(String[] args) {
        System.out.println(t2331. ());
    }

}