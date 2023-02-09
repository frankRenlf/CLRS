package leetcode.dailyWork;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/9 10:08
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */


class AuthenticationManager {
    int timeToLive;
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, this.timeToLive + currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer until = map.get(tokenId);
        if (until != null && until > currentTime) {
            map.put(tokenId, currentTime + this.timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        for (Map.Entry<String, Integer> el : map.entrySet()) {
            if (el.getValue() > currentTime) {
                cnt++;
            }
        }
        return cnt;
    }
}

public class T1797 {
    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa", 1);
        authenticationManager.generate("aaa", 2);
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb", 7);
        authenticationManager.renew("aaa", 8);
        authenticationManager.renew("bbb", 10);
        authenticationManager.countUnexpiredTokens(15);
    }
}
