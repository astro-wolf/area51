package problems.DisjointSets;

import java.util.HashMap;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 06/10/20 23:04
 *
 * Hashmap based Disjoint set implementation
 */
public class DisjointSet {

    private HashMap<Integer, Integer> db;

    public DisjointSet() {
        db = new HashMap<>();
    }

    /**
     * Add a new element to disjoint set
     * This element has no parent by default
     *
     * @param x Integer value to be stored in disjoint set
     */
    public void add(int x) {
        db.putIfAbsent(x, 0);
    }

    /**
     * Find and return the parent of x
     * This method assumes that x exists in disjoint set, so no clever stuff
     * This method also performs path compression, if required
     *
     * @param x Integer value, whose parent we want to find
     * @return parent of x
     */
    public int find(int x) {
        int par = db.get(x);
        if (par <= 0)
            return x;
        par = find(par);
        db.put(x, par);
        return par;
    }

    /**
     * Performs a size based union between x and y
     * This function assumes that both x and y exist in disjoint set
     * This function won't perform a union if both x and y have same parent
     * If both x and y have no parent, y will be made parent of x
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int xPar = find(x);
        int yPar = find(y);
        int xParNodeCount = db.get(xPar);
        int yParNodeCount = db.get(yPar);
        if (xPar != 0 && yPar != 0 && xPar == yPar)
            return;
        if (xParNodeCount > yParNodeCount) {
            // parent of x has more children
            db.put(y, xPar);
            db.put(xPar, --xParNodeCount);
        } else {
            // parent of y has more children
            // or both have equal children, in which case it doesn't matter where we put what
            db.put(x, yPar);
            db.put(yPar, --yParNodeCount);
        }
    }
}
