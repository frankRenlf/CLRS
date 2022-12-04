package leetcode.dailyWork;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/4 10:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1774 {
    int ret = 0;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ret = Arrays.stream(baseCosts).min().getAsInt();
        for (int c : baseCosts) {
            dfs(toppingCosts, 0, toppingCosts.length, c, target);
        }
        return ret;
    }

    private void dfs(int[] toppingCosts, int index, int length, int cur_cost, int target) {
        int sub1 = Math.abs(ret - target), sub2 = Math.abs(cur_cost - target);
        if (sub1 < sub2) {
            return;
        } else {
            if (sub1 > sub2) {
                ret = cur_cost;
            } else {
                ret = Math.min(ret, cur_cost);
            }
        }

        if (index >= length) return;
        dfs(toppingCosts, index + 1, length, cur_cost + toppingCosts[index] * 2, target);
        dfs(toppingCosts, index + 1, length, cur_cost + toppingCosts[index], target);
        dfs(toppingCosts, index + 1, length, cur_cost, target);
    }


}
