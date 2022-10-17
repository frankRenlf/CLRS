package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/17 11:57
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T102 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        int ret = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return Math.max(buy[n - 1], sell[n - 1]);
    }
    public int maxProfit_limitedTwoTransactions(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

}
