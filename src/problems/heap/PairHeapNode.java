package problems.heap;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 29/09/20 23:38
 *
 * This class is specifically made for Dijkstra's shortest path algo for graph, hence
 * the variable names won't be generic.
 */
public class PairHeapNode {
    /**
     * Index of node
     */
    public int index;
    /**
     * Total weight from source vertex to this vertex
     */
    public int weight;

    public PairHeapNode(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
