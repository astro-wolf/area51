package problems.graph;

import problems.heap.PairHeap;
import problems.heap.PairHeapNode;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 30/09/20 00:32
 *
 * Implemmentation of Dijsktras algo for shortest path of graph,
 * using Priority queue (https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Using_a_priority_queue)
 */
public class Dijkstras {

    public int[] dijkstras(Graph graph, int source) {
        if (graph == null)
            throw new NullPointerException("Graph cannot be null");
        int[] distances = new int[graph.vertices.length];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }
        Vertex[] vertices = graph.vertices;
        PairHeap heap = new PairHeap(graph.vertices.length);
        distances[source] = 0;
        heap.add(source, 0);
        while (!heap.isEmpty()) {
            PairHeapNode node = heap.getMin();
            Vertex v = vertices[node.index];
            for (Edge edge : v.adjVertices) {
                int d = node.weight + edge.weight;
                int edgeIdx = edge.index;
                if (distances[edgeIdx] == -1) {
                    distances[edgeIdx] = d;
                    heap.add(edgeIdx, d);
                }
                if (d < distances[edgeIdx]) {
                    distances[edgeIdx] = d;
                    heap.update(edgeIdx, d);
                }
            }
        }
        return distances;
    }

}
