package Test;

import algorithm.Sort;
import algorithm.Sorts.Bubble;
import algorithm.Sorts.Merge;
import algorithm.Sorts.Quick;
import algorithm.Sorts.Select;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SelectSort
 * @Package : Test
 * @createTime : 2022/7/22 14:04
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class TestSortMethod {

    private final int[] nums;

    public TestSortMethod(int n) {
        nums = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = rd.nextInt(1_0000);
        }
    }

    private int[] copyNums() {
        return Arrays.copyOf(nums, nums.length);
    }


    public void testSelectSort() {
        Sort sort = new Select();
        int[] tmp = copyNums();
        sort.sort(tmp);
        System.out.println("Before: " + Arrays.toString(nums));
        System.out.println("After: " + Arrays.toString(tmp));
    }

    public void testQuickSort() {
        Sort sort = new Quick();
        int[] tmp = copyNums();
        sort.sort(tmp);
        System.out.println("Before: " + Arrays.toString(nums));
        System.out.println("After: " + Arrays.toString(tmp));
    }

    public void testBubbleSort() {
        Sort sort = new Bubble();
        int[] tmp = copyNums();
        sort.sort(tmp);
        System.out.println("Before: " + Arrays.toString(nums));
        System.out.println("After: " + Arrays.toString(tmp));
    }

    public void testMergeSort() {
        Sort sort = new Merge();
        int[] tmp = copyNums();
        sort.sort(tmp);
        System.out.println("Before: " + Arrays.toString(nums));
        System.out.println("After: " + Arrays.toString(tmp));
    }

}
