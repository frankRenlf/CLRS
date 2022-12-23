package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/23 11:15
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2011 {

    public int finalValueAfterOperations(String[] operations) {
        int ret = 0;
        for (String x : operations) {
            if (x.contains("-")) ret--;
            else ret++;
        }
        return ret;
    }

}
