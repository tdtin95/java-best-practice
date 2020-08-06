package vn.tdtin.contest;

import java.io.*;
import java.util.*;

public class GraphTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        Graph graph = new Graph(n);

        for(int i = 0; i < n; i++) {
            input = br.readLine();
            String [] params = input.split(" ");
            graph.addEdge(Integer.parseInt(params[0]), Integer.parseInt(params[1]));

        }
        System.out.println(graph.isCyclic());

        // Complexity is O(V + E)
        //V : is number of vertex
        //E : is total edges
    }

    private static class Graph {

        private final int vertex;
        private final List<List<Integer>> adjacent;

        public Graph(int vertex)
        {
            this.vertex = vertex;
            adjacent = new ArrayList<>(vertex);

            for (int i = 0; i < vertex; i++)
                adjacent.add(new LinkedList<>());
        }

        private boolean checkCyclic(int i, boolean[] visited,
                                     boolean[] recursionStack)
        {

            if (recursionStack[i]) return true;

            if (visited[i]) return false;

            visited[i] = true;

            recursionStack[i] = true;
            List<Integer> children = adjacent.get(i);

            for (Integer c: children)
                if (checkCyclic(c, visited, recursionStack))
                    return true;

            recursionStack[i] = false;

            return false;
        }

        private void addEdge(int source, int dest) {
            adjacent.get(source).add(dest);
        }

        private boolean isCyclic()
        {

            boolean[] visited = new boolean[vertex];
            boolean[] recursionStack = new boolean[vertex];

            for (int i = 0; i < vertex; i++)
                if (checkCyclic(i, visited, recursionStack))
                    return true;

            return false;
        }

    }
}
