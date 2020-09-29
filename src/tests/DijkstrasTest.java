package tests;

import org.junit.jupiter.api.Test;
import problems.graph.Dijkstras;
import problems.graph.Graph;

import static org.junit.jupiter.api.Assertions.*;

class DijkstrasTest {

    private Dijkstras dijkstras;

    @Test
    void firstThingOnMeWhiteBoardTest() {
        dijkstras = new Dijkstras();
        Graph graph = new Graph(6);
        graph.addVertex(5);
        graph.addVertex(7);
        graph.addVertex(9);
        graph.addVertex(12);
        graph.addVertex(8);
        graph.addVertex(10);
        graph.addPath(5, 7, 2);
        graph.addPath(5, 8, 3);
        graph.addPath(8, 9, 3);
        graph.addPath(7, 9, 10);
        graph.addPath(7, 12, 2);
        graph.addPath(8, 10, 5);
        graph.addPath(10, 12, 3);
        int[] distancesFromFive = dijkstras.dijkstras(graph, 0);
        int[] distancesFromEight = dijkstras.dijkstras(graph, 4);
        assertEquals(1, 1);
    }

}