package problems.graph;

import java.util.ArrayList;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 25/09/20 23:18
 */
public class Vertex {

    public int value;
    public ArrayList<Edge> adjVertices;

    public Vertex(int value) {
        this.value = value;
        adjVertices = new ArrayList<>();
    }

}
