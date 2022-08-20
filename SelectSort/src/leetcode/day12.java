package leetcode;

import leetcode.algorithm.TreeNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/20 9:43
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day12 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int pivot = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[pivot]) {
                pivot = i;
            }
        }
        TreeNode node = new TreeNode(nums[pivot]);
        node.left = construct(nums, left, pivot - 1);
        node.right = construct(nums, pivot + 1, right);
        return node;
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            int next = pre + cur;
            pre = cur;
            cur = next;
        }
        return cur;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int next = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = next;
        }
        return cur;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()+1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        day12 d12 = new day12();
        System.out.println(d12.climbStairs(3));
    }


}
