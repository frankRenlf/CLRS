package leetcode.stage3;

import leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/27 10:24
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day18 {

    public boolean CheckPermutation(String s1, String s2) {
        int[] arr = new int[58];
        for (char x : s1.toCharArray()) {
            arr[x - 'A'] += 1;
        }
        for (char x : s2.toCharArray()) {
            arr[x - 'A'] -= 1;
            if (arr[x - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        findPath(ret, root, str);
        return ret;
    }

    private void findPath(List<String> ret, TreeNode root, StringBuffer str) {
        if (root == null) return;
        str.append(root.val);
        if (root.left == null && root.right == null) {
            ret.add(new String(str));
        }
        findPath(ret, root.left, str);
        findPath(ret, root.right, str);
    }

}
