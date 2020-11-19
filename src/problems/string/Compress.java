package problems.string;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 19/11/20 07:43
 *
 * Compress a string by keeping count of every char in front of that char in string.
 *
 * aabcccccaaa => a2b1c5a3
 *
 * If compressed string is greater than original string in length, return original string.
 */
public class Compress {

    public String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int consecutiveCount = 0;
        for (int i = 0; i < s.length(); i++)  {
            consecutiveCount++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }

}
