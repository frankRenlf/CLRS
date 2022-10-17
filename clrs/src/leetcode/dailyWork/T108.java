package leetcode.dailyWork;

import leetcode.algorithm.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/17 11:47
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, left, mid - 1);
        root.right = constructTree(nums, mid + 1, right);
        return root;
    }

}
