package Test;

import algorithm.Sort;
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
public class TestSort {

    private int[] nums;

    public TestSort(int n) {
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
        Select sort = new Select();
        int[] tmp = copyNums();
        sort.selectSort(tmp);
        System.out.println("Before: " + Arrays.toString(nums));
        System.out.println("After: " + Arrays.toString(tmp));
    }

    public void testQuickSort() {
        Sort sort = new Sort();
        int[] tmp = copyNums();
        sort.quickSort(tmp, 0, tmp.length - 1);
        System.out.println("Before: " + Arrays.toString(nums));
        System.out.println("After: " + Arrays.toString(tmp));
    }

    public static void main1(String[] args) {
        TestSort testSort = new TestSort(10);
        testSort.testSelectSort();
    }

    public static void main(String[] args) {
        TestSort testSort = new TestSort(10);
        testSort.testQuickSort();
    }


}
