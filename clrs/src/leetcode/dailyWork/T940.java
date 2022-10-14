package leetcode.dailyWork;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/14 13:05
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T940 {

    int sum = 0;

    public int distinctSubseqII(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        findSub(arr, n, 0);
        return sum;
    }

    private void findSub(char[] arr, int n, int index) {
        if (index == n) return;
        int[] contain = new int[26];
        for (int i = index; i < n; i++) {
            if (i > index && contain[122 - arr[i]] != 0) {
                continue;
            }
            contain[122 - arr[i]]++;
            sum++;
            findSub(arr, n, i + 1);
        }
    }

    static T940 t940 = new T940();

    public static void main(String[] args) {
        System.out.println(t940.distinctSubseqII("abc"));
    }

}
