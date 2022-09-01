package leetcode.stage2;

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

}
