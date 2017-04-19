package singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuzicong on 19/4/2017.
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        //		Set<Integer> set = new HashSet<Integer>(A.length);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(A.length);
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        int num = 0;

        Set<Integer> set = map.keySet();
        for (Integer in : set) {
            int n = map.get(in).intValue();
            if (n == 1) {
                num = in;
            }
        }
        return num;
    }
}
