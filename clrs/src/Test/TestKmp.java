package Test;

import leetcode.algorithm.KMP;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : Test
 * @createTime : 2022/8/14 14:43
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class TestKmp {

    public static void main(String[] args) {
        KMP Kmp = new KMP();
        System.out.println(Kmp.kmp("abcadca", "adc", 0));
    }

}
