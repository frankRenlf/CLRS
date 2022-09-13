package leetcode.stage3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/13 8:49
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day2 {

    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(0, num % 10);
            num /= 10;
        }
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) >= list.get(index)) {
                    index = j;
                }
            }
            if (list.get(i) < list.get(index)) {
                int tmp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, tmp);
                break;
            }
        }
        int ret = 0;
        for (int i = 0;i <n; i++) {
            ret *= 10;
            ret += list.get(i);
        }
        return ret;
    }

    static Day2 day2 = new Day2();

    public static void main(String[] args) {
        System.out.println(day2.maximumSwap(2736));
    }


}
