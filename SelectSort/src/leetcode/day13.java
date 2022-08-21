package leetcode;

import leetcode.algorithm.KMP;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/21 13:18
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day13 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        KMP Kmp = new KMP();
        int index = Kmp.kmp(sentence, searchWord, 0);
        if (index == -1) {
            return -1;
        }
        int pos = 1;
        for (int i = 0; i <= index; i++) {
            if (sentence.charAt(i) == ' ') {
                pos++;
            }
        }
        return pos;
    }

    public int isPrefixOfWord2(String sentence, String searchWord) {
        int len = sentence.length(), left = 0, right = 0, index = 1;
        while (left < len) {
            while (right < len && sentence.charAt(right) != ' ') {
                right++;
            }
            if (isPrefix(sentence, searchWord, left, right)) {
                return index;
            }
            index++;
            right++;
            left = right;
        }
        return -1;
    }

    private boolean isPrefix(String sentence, String searchWord, int left, int right) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (left + i > right || sentence.charAt(left + i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        day13 d13 = new day13();
        System.out.println(d13.isPrefixOfWord2("i love eating burger", "burg"));
    }

}
