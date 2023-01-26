package leetcode.dailyWork;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/26 9:38
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1663 {

    public String getSmallestString(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int sum = n;
        int right = n - 1;
        while (sum < k && right >= 0) {
            int sub = k - sum;
            if (sub > 25) {
                arr[right] = 26;
                sum += 25;
                right--;
            } else {
                arr[right] = sub + 1;
                break;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int x : arr) {
            char c = (char) ('a' + x - 1);
            ret.append(c);
        }
        return ret.toString();
    }

    static T1663 t1663 = new T1663();

    public static void main(String[] args) {
        System.out.println(t1663.getSmallestString(5, 73));
    }

}
