package problems.graph;

import problems.heap.PairHeap;
import problems.heap.PairHeapNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 30/09/20 00:32
 */
public class PathFinders {

    /**
     * Implementation of Bellman-ford algorithm
     */
    public int[] bellmanFord(Graph graph, int source) {
        Vertex[] vertices = graph.vertices;
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[vertices.length];
        int[] path = new int[vertices.length];
        boolean[] exist = new boolean[vertices.length];

        queue.offer(source);
        exist[source] = true;

        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[source] = 0;

        while (!queue.isEmpty()) {
            int vIdx = queue.poll();
            exist[vIdx] = false;
            Vertex v = vertices[vIdx];
            for (Edge e : v.adjVertices) {
                int d = distances[vIdx] + e.weight;
                if (distances[e.index] > d) {
                    distances[e.index] = d;
                    path[e.index] = vIdx;
                    if (!exist[e.index]) {
                        queue.offer(e.index);
                        exist[e.index] = true;
                    }
                }
            }
        }
        return distances;
    }

    /**
     * Implementation of Dijsktras algo for shortest path of graph,
     * using Priority queue (https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Using_a_priority_queue)
     */
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
