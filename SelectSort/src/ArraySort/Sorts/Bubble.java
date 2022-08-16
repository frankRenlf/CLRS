package ArraySort.Sorts;

import ArraySort.Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : algorithm.Sorts
 * @createTime : 2022/7/28 14:18
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Bubble implements Sort {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j + 1, j);
                }
            }
        }
    }

    @Override
    public void sort(int[] arr) {
        bubbleSort(arr);
    }
}
