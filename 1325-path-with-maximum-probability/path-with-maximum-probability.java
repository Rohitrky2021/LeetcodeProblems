import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create an adjacency list for the graph
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        if(start_node==end_node)return 0.0;
        
        // Build the graph using edges and succProb
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Edge(v, prob));
            graph.get(v).add(new Edge(u, prob));
        }
        
        // Dijkstra's algorithm to find the maximum probability path
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0; // Probability to start node is 1
        
        // PriorityQueue with lambda to prioritize higher probability
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Double.compare(maxProb[b], maxProb[a]));
        pq.add(start_node);
        
        while (!pq.isEmpty()) {
            int currNode = pq.poll();
            
            // if (currNode == end_node) {
            //     return maxProb[currNode]; // Return the maximum probability to reach end_node
            // }
            
            for (Edge edge : graph.get(currNode)) {
                int neighbor = edge.dest;
                double prob = edge.prob;
                
                // Relaxation step: update maxProb if we find a higher probability path
                if (maxProb[currNode] * prob > maxProb[neighbor]) {
                    maxProb[neighbor] = maxProb[currNode] * prob;
                    pq.add(neighbor);
                }
            }
        }
        
        // If we can't reach the end_node, return 0.0
        return maxProb[end_node]; // Return the maximum probability to reach end_node
    }

    // Inner class to represent edges in the graph
    class Edge {
        int dest;
        double prob;

        Edge(int d, double p) {
            this.dest = d;
            this.prob = p;
        }
    }
}
