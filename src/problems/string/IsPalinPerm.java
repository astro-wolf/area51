package problems.string;

import org.jetbrains.annotations.NotNull;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 13/11/20 08:25
 *
 * Find out if a string is a permutation of a palindrome.
 * Palindrome can be a non-dictionary word.
 */
public class IsPalinPerm {

    public boolean isPalinPer(@NotNull String s) {
        int bitVector = getBitVector(s);
        return bitVector == 0 || hasOneBit(bitVector);
    }

    private boolean hasOneBit(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private int getBitVector(String s) {
        int bitVector = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            int index = getIndexForChar(c);
            bitVector = toggle(bitVector, index);
        }
        return bitVector;
    }

    private int toggle(int bitVector, int index) {
        if (index < 0)
            return bitVector;
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private int getIndexForChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        return -1;
    }

}
