package problems.string;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 19/10/20 23:38
 *
 * This class implements Rabin-Karp algorithm to check whether a string
 * exists in a bigger string or not.
 * I have written a useless hashing function, so there may be lots of
 * spurious hits here.
 */
public class RabinKarp {

    /**
     * Implement Rabin-Karp to check whether m exist in s.
     * @param s
     * @param m
     * @return true if m exist in s, false otherwise
     */
    public boolean rabinKarp(String s, String m) {
        if (m.length() > s.length())
            return false;
        return rabinKarp(s.toCharArray(), m.toCharArray());
    }

    private boolean rabinKarp(char[] s, char[] m) {
        int sa = 0;
        int ma = 0;
        for (char c : m) {
            ma += c;
        }
        for (int i = 0; i < m.length - 1; i++) {
            sa += s[i];
        }
        for (int i = 0; i < s.length - m.length; i++) {
            sa += s[(i + m.length) - 1];
            if (sa == ma) {
                for (int j = 0; j < m.length; j++) {
                    if (m[j] != s[j + 1])
                        return false;
                }
                return true;
            }
            sa -= s[i];
        }
        return false;
    }

}
