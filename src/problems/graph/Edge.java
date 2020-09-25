package problems.graph;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 25/09/20 23:17
 */
public class Edge {

    public int index;
    public int weight = 1; // assume weight is 1. This might be handy when graph is unweighted.

    public Edge(int idx) {
        this.index = idx;
    }

    public Edge(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

}
