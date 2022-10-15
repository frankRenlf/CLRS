package leetcode.dailyWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/15 10:30
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1441 {

    public List<String> buildArray(int[] target, int n) {
        int length = target.length;
        List<String> list = new ArrayList<>();
        for (int i = 1, index = 0; i <= target[length - 1]; i++) {
            if (target[index] == i) {
                list.add("Push");
                index++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

}
