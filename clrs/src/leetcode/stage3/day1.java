package leetcode.stage3;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/12 12:32
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day1 {

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; i--) {
            int x = n - i;
            if (nums[i] >= x && (i == 0 || nums[i - 1] < x)) return x;
        }
        return -1;
    }

    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] pivot = ps[i];
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x1 = pivot[0], y1 = pivot[1];
                int x2 = ps[j][0], y2 = ps[j][1];
                int subX = x1 - x2, subY = y1 - y2;
                int k = gcd(subX, subY);
                String key = subX / k + "_" + subY / k;
                map.put(key, map.getOrDefault(key, 1) + 1);
                max = Math.max(map.get(key), max);
            }
        }
        return max;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int end = candidates.length;
        Arrays.sort(candidates);
        combine_dfs(candidates, target, 0, end, ret, stack);
        return ret;
    }

    private void combine_dfs(int[] candidates, int target, int begin, int end, List<List<Integer>> ret, Stack<Integer> stack) {
        if (target == 0) {
            ret.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < end; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] >= 0) {
                stack.push(candidates[i]);
                combine_dfs(candidates, target - candidates[i], i + 1, end, ret, stack);
                stack.pop();
            } else {
                return;
            }
        }
    }


    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static day1 d1 = new day1();

    public static void main(String[] args) {
        System.out.println(d1.specialArray(new int[]{3, 6, 7, 7, 0}));
    }

}
