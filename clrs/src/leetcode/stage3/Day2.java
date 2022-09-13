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

    // 1 3 6
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int mul = 1;
        for (int end = 0, begin = 0; end < n; end++) {
            mul *= nums[end];
            if (mul < k) {
                count += (end - begin + 1);
            }else {

            }
        }
    }

    public int maximumSwap2(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        int maxIndex = n - 1;
        int index1 = -1, index2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            } else if (nums[i] < nums[maxIndex]) {
                index1 = i;
                index2 = maxIndex;
            }
        }
        if (index1 >= 0) {
            swap(nums, index1, index2);
            return Integer.parseInt(new String(nums));
        }
        return num;
    }

    private void swap(char[] nums, int index1, int index2) {
        char tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

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
        for (int i = 0; i < n; i++) {
            ret *= 10;
            ret += list.get(i);
        }
        return ret;
    }

    static Day2 day2 = new Day2();

    public static void main(String[] args) {
        System.out.println(day2.maximumSwap(9973));
    }


}
