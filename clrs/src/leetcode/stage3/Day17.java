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
 * @createTime : 2022/9/26 10:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day17 {

    int max = -1;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightView(list, root, 0);
        return list;
    }

    private void rightView(List<Integer> list, TreeNode root, int depth) {
        if (root == null) return;
        if (depth > max) {
            max = depth;
            list.add(root.val);
        }
        rightView(list, root.right, depth + 1);
        rightView(list, root.left, depth + 1);
    }

    public int[] missingTwo_pro(int[] nums) {
        int val = 0;
        int n = nums.length + 2;
        for (int num : nums) {
            val ^= num;
        }
        for (int i = 1; i <= n; i++) {
            val ^= i;
        }
        int key = val == Integer.MIN_VALUE ? val : (val & (-val));
        int t1 = 0, t2 = 0;
        for (int num : nums) {
            if ((num & key) > 0) {
                t1 ^= num;
            } else {
                t2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & key) > 0) {
                t1 ^= i;
            } else {
                t2 ^= i;
            }
        }
        return new int[]{t1, t2};
    }

    public int[] missingTwo(int[] nums) {
        int[] ret = new int[2];
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != j + 1) {
                if (ret[0] == 0) {
                    ret[0] = j + 1;
                } else {
                    ret[1] = j + 1;
                    break;
                }
                i--;
            }
            j++;
        }
        if (ret[0] == 0) {
            ret[0] = nums[nums.length - 1] + 1;
            ret[1] = ret[0] + 1;
        }
        if (ret[1] == 0) {
            ret[1] = nums[nums.length - 1] + 1;
        }
        return ret;
    }

    static Day17 day17 = new Day17();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(day17.missingTwo_pro(new int[]{1, 3})));
    }
}
