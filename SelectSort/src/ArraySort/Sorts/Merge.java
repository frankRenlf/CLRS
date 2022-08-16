package ArraySort.Sorts;

import ArraySort.Sort;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : algorithm.Sorts
 * @createTime : 2022/7/28 14:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Merge implements Sort {

    private void mergeSortWhile(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (right <= left) {
                continue;
            }
            int mid = left + ((right - left) >>> 1);

        }
    }


    @Override
    public void sort(int[] arr) {
        mergeSortRec(arr, 0, arr.length - 1);
    }

    private void mergeSortRec(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >>> 1);
        mergeSortRec(arr, left, mid);
        mergeSortRec(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int[] tmp = new int[right - left + 1];
        int index = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2]) {
                tmp[index++] = arr[s1++];
            } else {
                tmp[index++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[index++] = arr[s1++];
        }
        while (s2 <= right) {
            tmp[index++] = arr[s2++];
        }
        for (int x : tmp) {
            arr[left++] = x;
        }
    }
}
