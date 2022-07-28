package algorithm.Sorts;

import algorithm.Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : algorithm
 * @createTime : 2022/7/27 13:55
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Quick implements Sort {


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int div = partition(nums, start, end);
        quickSort(nums, start, div);
        quickSort(nums, div + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && pivot <= nums[end]) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && pivot > nums[start]) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }


    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
