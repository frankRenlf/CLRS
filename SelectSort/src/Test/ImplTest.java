package Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : Test
 * @createTime : 2022/7/28 14:23
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class ImplTest {

    public static void main1(String[] args) {
        TestSortMethod testSort = new TestSortMethod(10);
        testSort.testSelectSort();
    }

    public static void main2(String[] args) {
        TestSortMethod testSort = new TestSortMethod(10);
        testSort.testQuickSort();
    }

    public static void main(String[] args) {
        TestSortMethod testSort = new TestSortMethod(10);
        testSort.testBubbleSort();
    }

}
