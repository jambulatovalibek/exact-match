import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, Map<Vertex, Double>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        if (hasVertex(v))
            return;

        map.put(v, new LinkedHashMap<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return;

        map.get(source).put(dest, weight);

        if (undirected)
            map.get(dest).put(source, weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;

        return map.get(source).containsKey(dest);
    }

    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;

        return new LinkedList<>(map.get(v).keySet());
    }

    public double getWeight(Vertex source, Vertex dest) {
        return map.get(source).get(dest);
    }
}
