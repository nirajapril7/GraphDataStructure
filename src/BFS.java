import java.util.*;

public class BFS {
    private Map<Integer, List<Integer>> adjList;

    public BFS() {
        this.adjList = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // For undirected graph
    }

    // BFS method
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
             |
             7
         */
        BFS graph = new BFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);

        System.out.println("BFS starting from vertex 1:");
        graph.bfs(1);
    }
}
