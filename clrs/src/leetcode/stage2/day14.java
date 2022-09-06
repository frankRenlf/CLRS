package leetcode.stage2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/6 12:11
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day14 {

    public int uniqueLetterString1(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] record = new int[26];
        int[] left = new int[len];
        Arrays.fill(record, -1);
        for (int i = 0; i < len; i++) {
            int pos = arr[i] - 'A';
            left[i] = record[pos];
            record[pos] = i;
        }
        int[] right = new int[len];
        Arrays.fill(record, len);
        for (int i = len - 1; i >= 0; i--) {
            int pos = arr[i] - 'A';
            right[i] = record[pos];
            record[pos] = i;
        }
        for (int i = 0; i < len; i++) {
            count += (i - left[i]) * (right[i] - i);
        }
        return count;
    }

    public int uniqueLetterString(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                count += countUniqueChars(s.substring(i, j));
            }
        }
        return count;
    }

    private int countUniqueChars(String substring) {
        int[] arr = new int[26];
        for (char x : substring.toCharArray()) {
            arr[x - 65]++;
        }
        int sum = 0;
        for (int x : arr) {
            if (x == 1) sum++;
        }
        return sum;
    }

    static day14 d14 = new day14();

    public static void main(String[] args) {
        System.out.println(d14.uniqueLetterString1("LEETCODE"));
    }

}
