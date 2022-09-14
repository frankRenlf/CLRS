package leetcode.stage3;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/14 9:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day3 {

    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sub = n / 20;
        double sum = 0.0;
        for (int i = sub; i < n - sub; i++) {
            sum += arr[i];
        }
        return sum / (n - sub * 2);
    }

}
