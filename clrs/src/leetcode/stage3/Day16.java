package leetcode.stage3;

import leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/25 14:47
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day16 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) return;
        addRoot(root);
        TreeNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            cur.left = null;
            cur.right = list.get(i);
            cur = cur.right;
        }
    }

    private void addRoot(TreeNode root) {
        if (root == null) return;
        list.add(root);
        addRoot(root.left);
        addRoot((root.right));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findPath(ret, list, root, targetSum);
        return ret;
    }

    private void findPath(List<List<Integer>> ret, List<Integer> list, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            ret.add(new ArrayList<>(list));
        }
        findPath(ret, list, root.left, targetSum - root.val);
        findPath(ret, list, root.right, targetSum - root.val);
        list.remove(list.size() - 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits_vio(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); ++j) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                ++ans;
            }
        }
        return ans;
    }

    static int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    char[] s;
    int[][] dp;

    public int rotatedDigits(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][2];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true);
    }

    int f(int i, int hasDiff, boolean isLimit) {
        if (i == s.length) {
//            System.out.printf("dp[%d][%d]:%d",i,hasDiff,);
            System.out.println(i + ":" + hasDiff);
            return hasDiff; // 只有包含 2/5/6/9 才算一个好数
        }
        if (!isLimit && dp[i][hasDiff] >= 0) return dp[i][hasDiff];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; ++d) {
            // 枚举要填入的数字 d
            // d 不是 3/4/7
            if (DIFFS[d] != -1) {
                res += f(i + 1, hasDiff | DIFFS[d], isLimit && d == up);
                if (i == 0) {
                    System.out.println(res);
                }

            }
        }
        if (!isLimit) dp[i][hasDiff] = res;
        return res;
    }

    static Day16 day16 = new Day16();

    public static void main(String[] args) {
        day16.rotatedDigits(22);
//        System.out.println(5|-1);
    }

}
