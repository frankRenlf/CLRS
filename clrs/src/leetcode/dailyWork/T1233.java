package leetcode.dailyWork;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/8 11:23
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1233 {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        List<String> list = new ArrayList<>();
        for (String s : folder) {
            int i = s.length() - 1;
            for (; i > 0; i--) {
                if (s.charAt(i) == '/' && set.contains(s.substring(0, i))) {
                    break;
                }
            }
            if (i == 0) list.add(s);
        }
        return list;
    }
}
