package problems.graph;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 25/09/20 23:16
 *
 * Somehow, we assume that value at every vertex will be unique in this graph.
 * Because, otherwise, getIndex method will definitely fail.
 *
 * Maybe if I put my mind to it, I'll come up with a solution, where duplicate
 * values are allowed. But, it's 23:33, I didn't have coffee in days, and  I am
 * not interested in it right now, so..... :P
 */
public class Graph {

    Vertex[] vertices;
    int size;
    int count = 0;

    public Graph(int size) {
        vertices = new Vertex[size];
        this.size = size;
    }

    public boolean addVertex(int val) {
        if (count == size)
            return false;
        vertices[count++] = new Vertex(val);
        return true;
    }

    public boolean addPath(int u, int v, int weight) {
        int uIdx = getIndex(u);
        int vIdx = getIndex(v);
        if (uIdx == -1 || vIdx == -1)
            return false;
        vertices[uIdx].adjVertices.add(
                new Edge(vIdx, weight)
        );
        return true;
    }

    // TODO: add removePath and removeVertex methods

    public int getIndex(int val) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].value == val) {
                return i;
            }
        }
        return -1;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }
}
