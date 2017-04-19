package longestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liuzicong on 19/4/2017.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<String>();
        Set<String> set = new HashSet<String>(s.length());
        int maxlen = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (set.contains(String.valueOf(chars[j]))) {
                    if (set.size() > maxlen) {
                        maxlen = set.size();
                    }
                    set.clear();
                    break;
                } else {
                    if (Character.isLetter(chars[j])) {
                        set.add(String.valueOf(chars[j]));
                        if (set.size() > maxlen) {
                            maxlen = set.size();
                        }
                    }
                }
            }
        }
        return maxlen;
    }
}
