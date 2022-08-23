package leetcode;

import leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/22 20:15
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day14 {
    static day14 d14 = new day14();

    public static void main(String[] args) {
        System.out.println(d14.reverseBits(43261596));
    }

    public int singleNumber(int[] nums) {
        int ret = nums[0];
        for(int i =1;i<nums.length;i++){
            ret^=nums[i];
        }
        return ret;
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 31; i >= 0 && n != 0; i--) {
            ret += (n & 1) << i;
            n >>>= 1;
        }
        return ret;
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int n = (1 << height) - 1;
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> elem = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                elem.add(" ");
            }
            ret.add(elem);
        }
        printTree_dfs(ret, root, 0, (n - 1) / 2, height - 1);
        return ret;
    }

    private void printTree_dfs(List<List<String>> ret, TreeNode root, int level, int n, int height) {
        ret.get(level).set(n, Integer.toString(root.val));
        if (root.left != null) {
            printTree_dfs(ret, root.left, level + 1, n - (1 << height - level - 1), height);
        }
        if (root.right != null) {
            printTree_dfs(ret, root.right, level + 1, n + (1 << height - level - 1), height);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main1(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        day14 d14 = new day14();
        System.out.println(d14.getHeight(root));
    }

}
