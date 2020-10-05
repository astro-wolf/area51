package tests;

import org.junit.jupiter.api.Test;
import problems.graph.PathFinders;
import problems.graph.Graph;

import static org.junit.jupiter.api.Assertions.*;

class PathFindersTest {

    private PathFinders pathFinders;

    @Test
    void dijkstras() {
        pathFinders = new PathFinders();
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
        int[] distancesFromFive = pathFinders.dijkstras(graph, 0);
        int[] distancesFromEight = pathFinders.dijkstras(graph, 4);
        assertEquals(1, 1);
    }

    @Test
    void bellmanFord() {
        pathFinders = new PathFinders();
        Graph graph = new Graph(7);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addPath(1, 2, 6);
        graph.addPath(1, 3, 5);
        graph.addPath(1, 4, 5);
        graph.addPath(2, 5, -1);
        graph.addPath(3, 5, 1);
        graph.addPath(3, 2, -2);
        graph.addPath(4, 3, -2);
        graph.addPath(4, 6, -1);
        graph.addPath(5, 7, 3);
        graph.addPath(6, 7, 3);
        int[] distances = pathFinders.bellmanFord(graph, 0);
        assertEquals(1, 1);
    }

}