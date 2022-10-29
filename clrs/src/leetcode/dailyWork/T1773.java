package leetcode.dailyWork;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/29 9:56
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        if (Objects.equals(ruleKey, "type")) index = 0;
        else if (Objects.equals(ruleKey, "color")) index = 1;
        else index = 2;
        int ret = 0;
        for (List<String> elem : items) {
            if (items.get(index).equals(ruleValue)) {
                ret++;
            }
        }
        return ret;
    }

}
