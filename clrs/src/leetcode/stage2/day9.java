package leetcode.stage2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/1 14:45
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day9 {

    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) return new int[0];
        int[] ret = new int[prices.length];
        for (int i = 0; i < ret.length; i++) {
            int j = i + 1;
            for (; j < ret.length; j++) {
                if (prices[j] <= prices[i]) {
                    ret[i] = prices[i] - prices[j];
                    break;
                }
            }
            if (j == ret.length) ret[i] = prices[i];
        }
        return ret;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(visited, nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(boolean[] visited, int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            visited[i] = true;
            backtrack(visited, nums, ans, idx + 1, perm);
            visited[i] = false;
            perm.remove(idx);
        }
    }


}
