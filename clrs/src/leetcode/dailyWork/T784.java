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
 * @createTime : 2022/10/30 13:58
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T784 {

    List<String> list = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        find(s.toCharArray(), 0, s.length());
        return list;
    }

    private void find(char[] arr, int i, int end) {
        while (i < end && Character.isDigit(arr[i])) {
            i++;
        }
        if (i >= end) {
            list.add(new String(arr));
            return;
        }
        find(arr, i + 1, end);
        arr[i] ^= 32;
        find(arr, i + 1, end);
    }
}
