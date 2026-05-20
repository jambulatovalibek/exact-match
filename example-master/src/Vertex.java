
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public T getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<T> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex<?> vertex)) return false;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
