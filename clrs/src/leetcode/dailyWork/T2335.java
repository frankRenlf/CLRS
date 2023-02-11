package leetcode.dailyWork;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/11 8:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2335 {

    public int fillCups(int[] amount) {
        int sum = Arrays.stream(amount).sum();
        Integer key = null;
        for (int el : amount) {
            if (sum < 2 * el) {
                key = el;
                break;
            }
        }
        if (key != null) {
            return key;
        }
        return sum % 2 == 0 ? sum / 2 : sum / 2 + 1;
    }

    public int fillCups2(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }


}
