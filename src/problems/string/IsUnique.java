package problems.string;

import java.util.HashSet;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 11/11/20 08:28
 *
 * Write a function which returns true, if all the characters in a string are unique
 */
public class IsUnique {

    public boolean isUnique(String s) {
        return isUniqueUsingHashTable(s);
    }

    public boolean isUniqueUsingHashTable(String s) {
        if (s == null || s.length() < 2)
            return true;
        HashSet<Character> h = new HashSet<>();
        for (int i =  0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (h.contains(c))
                return false;
            h.add(c);
        }
        return true;
    }

    public boolean isUniqueForAllSmall(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

}
