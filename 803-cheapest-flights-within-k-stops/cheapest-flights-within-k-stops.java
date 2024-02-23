import java.util.*;

// Dijstra But can't  Be Used for -ve Weighted Cycles 
 

public class Solution {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    static class Info {
        int v;
        int cost;
        int stop;

        Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    @SuppressWarnings("unchecked")
    public static int findCheapestPrice(int n,int flights[][] , int src, int dest, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

   PriorityQueue<Info> q=new PriorityQueue<>((a,b)->a.stop-b.stop);

        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int V = e.dest;
                int W = e.wt;
                if (curr.cost + W < dist[V] && curr.stop <= k) {
                    dist[V] = curr.cost + W;
                    q.add(new Info(V, dist[V], curr.stop + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }
}


// Bellman Ford Algo Bus  Queue Nhi use hota tho use prta hai thora but check krna eska TC acha kyu aaya ?

class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i <= k; i++) {
            if (isRoutePossible(distance, flights)) {
                break;
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    private boolean isRoutePossible(int[] dist, int[][] flights) {
        int[] copy = Arrays.copyOf(dist, dist.length);
        boolean result = true;

        for (int[] flight : flights) {
            int src = flight[0];
            int dst = flight[1];
            int  cost =flight[2];

            if (copy[src] < Integer.MAX_VALUE && dist[dst] > dist[src] + cost) {
                dist[dst] = cost + copy[src];
                result = false;
            }
        }
        return result;
    }
}