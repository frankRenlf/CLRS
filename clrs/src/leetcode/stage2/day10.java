package leetcode.stage2;

import leetcode.algorithm.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/2 10:55
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day10 {

    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left), right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Stack<Integer> path = new Stack<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Stack<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.push(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        if (candidates == null || candidates.length == 0) return ret;
        Arrays.sort(candidates);

        combinationSum2_dfs(ret, path, candidates, target, 0, candidates.length);
        return ret;
    }

    private void combinationSum2_dfs(List<List<Integer>> ret, Stack<Integer> path, int[] candidates, int target, int begin, int length) {
        if (target == 0) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) {
                break;
            } else {
                path.push(candidates[i]);
                combinationSum2_dfs(ret, path, candidates, target - candidates[i], i + 1, length);
                path.pop();
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ret;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        letterCombinations_dfs(ret, phoneMap, digits, 0, new StringBuffer());
        return ret;
    }

    private void letterCombinations_dfs(List<String> ret, Map<Character, String> phoneMap, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            ret.add(new String(stringBuffer));
            return;
        }
        char digit = digits.charAt(index);
        String letter = phoneMap.get(digit);
        for (int i = 0; i < letter.length(); i++) {
            stringBuffer.append(letter.charAt(i));
            letterCombinations_dfs(ret, phoneMap, digits, index + 1, stringBuffer);
            stringBuffer.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        day10 d10 = new day10();
        List<List<Integer>> res = d10.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }


}
