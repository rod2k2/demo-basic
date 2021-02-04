package learn.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rod ,have fun with coding
 * @date 2021/2/2 21:11
 */
public class Graph {

    /**
     * present adjacency list with below style
     *   A -> B,C
     *   B -> A,D
     *
     */
    private Map<Vertex, List<Vertex>> adjacencyList = new ConcurrentHashMap<>();

    public Graph addVertex(String label) {
        adjacencyList.putIfAbsent(new Vertex(label), new ArrayList<>());
        return this;
    }

    public Graph removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjacencyList.values().stream().forEach(e -> e.remove(v));
        adjacencyList.remove(new Vertex(label));
        return this;
    }

    public Graph addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
        return this;
    }

    public Graph removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjacencyList.get(v1);
        List<Vertex> eV2 = adjacencyList.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }
        return this;
    }
}
