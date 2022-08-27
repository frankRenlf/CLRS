package leetcode.stage2;

import leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/27 10:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

class Solution {
    //abca ac
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;
        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        while (hi < s.length()) {
            if (cnt[s.charAt(hi)] > 0) {
                cnt[s.charAt(hi++)]--;
                if (hi - lo == p.length()) res.add(lo);
            } else {
                cnt[s.charAt(lo++)]++;
            }
        }
        return res;
    }
}

public class day4 {


    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();
        return dfs(levelMin, root, 1, 1);
    }

    public int dfs(Map<Integer, Integer> levelMin, TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
//        if(!levelMin.containsKey(depth))
        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(dfs(levelMin, node.left, depth + 1, index * 2),
                        dfs(levelMin, node.right, depth + 1, index * 2 + 1)));
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0;
        int len = nums.length;
        int count = 0;
        int product = 1;
        while (right < len) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0;
        int count = 0, len = nums.length;
        int ret = len + 1;
        while (right < len) {
            count += nums[right];
            while (count >= target) {
                count -= nums[left];
                ret = Math.min(ret, right - left + 1);
                left++;
            }
            right++;
        }
        return ret != len + 1 ? ret : 0;
    }

    static day4 d4 = new day4();

    public static void main(String[] args) {
        System.out.println(d4.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }


}
