import java.util.*;

/* Find a Minimum Spanning Tree for a weighted undirected graph.
 * Returns a total cost of the tree. 
 * This is a solution to the hackerrank.com problem: 
 * https://www.hackerrank.com/challenges/primsmstsub
 * */
public class Prim {

    private static class Vertex  {
        private Integer id;
        private List<Edge> edges = new ArrayList<>();
        public void addEdge(Edge edge) { edges.add(edge); }
        public Vertex(Integer id) { this.id = id; };

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

    }

    private static class Edge implements Comparable<Edge> {
        private Vertex destination;
        private int weight;
        public Edge(Vertex destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo (Edge other) {
            return Integer.compare(weight, other.weight);
        }

    }

    private static int getMstSum(Vertex start, Map<Integer, Vertex> vertices) {
        int cost = 0;
        List<Vertex> unvisited = new ArrayList<>(vertices.values());
        Vertex vertex = start;
        unvisited.remove(vertex);
        PriorityQueue<Edge> vertexQueue = new PriorityQueue<>();

        while (!unvisited.isEmpty()) {
            for (Edge e : vertex.edges) {
                if (unvisited.contains(e.destination)) {
                    vertexQueue.add(e);
                }
            }
            Edge e = vertexQueue.poll();
            if (unvisited.contains(e.destination)) {
                cost += e.weight;
            }
            vertex = e.destination; 
            unvisited.remove(vertex); 
        }
        return cost;
    }

    private static Map<Integer, Vertex> initializeVertices(int m) {
        Map<Integer, Vertex> vertices = new TreeMap<>();
        for (int i = 1; i <= m; i++) {
            Vertex vertex = new Vertex(i);
            vertices.put(i, vertex);
        }
        return vertices;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int n = in.nextInt(); // node
        int m = in.nextInt(); // edges
        Map<Integer, Vertex> vertices = initializeVertices(n);
        for (int j = 0; j < m; j++) {
            Vertex vertexA = vertices.get(in.nextInt());
            Vertex vertexB = vertices.get(in.nextInt());
            int weight = in.nextInt();
            Edge a = new Edge(vertexA, weight);
            Edge b = new Edge(vertexB, weight);
            vertexA.addEdge(b);  
            vertexB.addEdge(a);
        }
        int start = in.nextInt();
        Vertex startVertex = vertices.get(start);
        System.out.println(getMstSum(startVertex, vertices));
    }
}
