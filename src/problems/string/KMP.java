package problems.string;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 21/10/20 00:25
 */
public class KMP {

    public int exist(String T, String P) {
        if (P.length() > T.length())
            return -1;
        return exist(T.toCharArray(), P.toCharArray());
    }

    private int exist(char[] T, char[] P) {
        int i = 0, j = 0, n = T.length, m = P.length;
        int[] F = prefixTable(P, m);
        while (i < n) {
            if (T[i] == P[j]) {
                if (j == m - 1) {
                    return i - j;
                } else {
                    i++;
                    j++;
                }
            } else if (j > 0) {
                j = F[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    private int[] prefixTable(char[] P, int m) {
        int i = 1, j =  0;
        int[] F = new int[m];
        F[0] = 0;
        while (i < m) {
            if (F[i] == F[j]) {
                F[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = F[j - 1];
            } else {
                F[i] = 0;
                i++;
            }
        }
        return F;
    }

}
