package leetcode.stage3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/10/8 10:46
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day27 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] index2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            index2[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(index2, (a, b) -> {
            return nums2[a] - nums2[b];
        });
        int left = 0, right = n - 1;
        int[] ret = new int[n];
        for (int j : nums1) {
            if (j > nums2[index2[left]]) {
                ret[index2[left]] = j;
                left++;
            } else {
                ret[index2[right]] = j;
                right--;
            }
        }
        return ret;
    }

}
