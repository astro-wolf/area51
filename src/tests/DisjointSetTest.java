package tests;

import org.junit.jupiter.api.Test;
import problems.DisjointSets.DisjointSet;

import static org.junit.jupiter.api.Assertions.*;

class DisjointSetTest {

    private DisjointSet disjointSet;

    @Test
    void noParent() {
        disjointSet = new DisjointSet();
        disjointSet.add(1);
        assertEquals(1, disjointSet.find(1));
    }

    @Test
    void oneLevelParentWithTwoParentUnion() {
        disjointSet = new DisjointSet();
        disjointSet.add(1);
        disjointSet.add(2);
        disjointSet.union(1, 2);
        assertEquals(2, disjointSet.find(1));
    }

    @Test
    void multipleSets() {
        disjointSet = new DisjointSet();
        disjointSet.add(1);
        disjointSet.add(2);
        disjointSet.add(3);
        disjointSet.add(4);
        disjointSet.union(1, 2);
        disjointSet.union(3, 4);
        assertEquals(2, disjointSet.find(1));
        assertEquals(4, disjointSet.find(3));
    }

    @Test
    void unionFromDifferentSets() {
        disjointSet = new DisjointSet();
        disjointSet.add(1);
        disjointSet.add(2);
        disjointSet.add(3);
        disjointSet.add(4);
        disjointSet.union(1, 2);
        disjointSet.union(3, 4);
        disjointSet.union(1, 3);
        assertEquals(4, disjointSet.find(1));
    }

}