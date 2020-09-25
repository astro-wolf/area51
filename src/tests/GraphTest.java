package tests;

import org.junit.jupiter.api.Test;
import problems.graph.Edge;
import problems.graph.Graph;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph;

    @Test
    void empty() {
        graph = new Graph(9);
        assertEquals(0, graph.getCount());
    }

    @Test
    void fillItUp() {
        graph = new Graph(4);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        assertTrue(graph.addVertex(4));
        assertFalse(graph.addVertex(45));
    }

    @Test
    void getIndex() {
        graph = new Graph(3);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        assertEquals(0, graph.getIndex(1));
        assertEquals(1, graph.getIndex(2));
        assertEquals(2, graph.getIndex(3));
        assertEquals(-1, graph.getIndex(5));
    }

    @Test
    void addPath() {
        graph = new Graph(3);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        assertTrue(graph.addPath(1, 2, 2));
        assertTrue(graph.addPath(1, 3, 4));
        assertFalse(graph.addPath(4, 5, 5));
        ArrayList<Edge> edges = graph.getVertices()[0].adjVertices;
        assertEquals(2, edges.size());
        assertEquals(1, edges.get(0).index);
        assertEquals(2, edges.get(1).index);
        assertEquals(2, edges.get(0).weight);
        assertEquals(4, edges.get(1).weight);
    }

}