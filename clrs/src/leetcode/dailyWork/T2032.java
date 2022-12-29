package leetcode.dailyWork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/29 10:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> pre = new HashSet<>();
        List<Integer> ret = new ArrayList<>();
        for(int x:nums1){
            pre.add(x);
            set.add(x);
        }
        for(int x:nums2){
            if(pre.contains(x)&&!ret.contains(x)){
                ret.add(x);
            }
            set.add(x);
        }
        for(int x:nums3){
            if(set.contains(x)&&!ret.contains(x)){
                ret.add(x);
            }
        }
        return ret;
    }
    static T2032 t2032=new T2032();

    public static void main(String[] args) {
//        System.out.println(t2032.twoOutOfThree());
    }

}
