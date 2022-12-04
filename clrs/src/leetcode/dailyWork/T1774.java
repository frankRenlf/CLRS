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
        int len = toppingCosts.length;
        for (int c : baseCosts) {
            dfs(toppingCosts, 0, len, c, target);
        }
        return ret;
    }

    private void dfs(int[] toppingCosts, int index, int length, int cur_cost, int target) {
        if (Math.abs(ret - target) < cur_cost - target) {
            return;
        } else if (Math.abs(ret - target) >= Math.abs(cur_cost - target)) {
            if (Math.abs(ret - target) > Math.abs(cur_cost - target)) {
                ret = cur_cost;
            } else {
                ret = Math.min(ret, cur_cost);
            }
        }
        if (index == length) return;
        dfs(toppingCosts, index + 1, length, cur_cost + toppingCosts[index] * 2, target);
        dfs(toppingCosts, index + 1, length, cur_cost + toppingCosts[index], target);
        dfs(toppingCosts, index + 1, length, cur_cost, target);
    }

    public void dfs2(int[] toppingCosts, int p, int curCost, int target) {
        if (Math.abs(ret - target) < curCost - target) {
            return;
        } else if (Math.abs(ret - target) >= Math.abs(curCost - target)) {
            if (Math.abs(ret - target) > Math.abs(curCost - target)) {
                ret = curCost;
            } else {
                ret = Math.min(ret, curCost);
            }
        }
        if (p == toppingCosts.length) {
            return;
        }
        dfs2(toppingCosts, p + 1, curCost + toppingCosts[p] * 2, target);
        dfs2(toppingCosts, p + 1, curCost + toppingCosts[p], target);
        dfs2(toppingCosts, p + 1, curCost, target);
    }


}
