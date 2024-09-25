// M1

class Solution1 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].getKey(), column = cells[next].getValue();
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }
}


// M2

class Solution2 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] moves = new int[n * n + 1];
        Arrays.fill(moves, -1);
        
        boolean leftToRight = true;
        int idx = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    moves[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    moves[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return steps;
                }
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int dest = moves[next] == -1 ? next : moves[next];
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}

 
class Solution {

    // Function to calculate minimum throws to reach the last square in Snakes and Ladders
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] board1D = new int[n * n + 1];  // Flattened board array
        boolean leftToRight = true;
        int idx = 1;

        // Flatten the 2D board into a 1D array
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    board1D[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    board1D[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;  // Switch direction after each row
        }

        // Queue for BFS traversal, storing position and the number of moves
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.add(new int[]{1, 0});  // Start at square 1 with 0 moves
        visited[1] = true;

        // BFS to find the shortest path to square n*n
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int moves = current[1];

            // If we reach the final square
            if (pos == n * n) {
                return moves;
            }

            // Try all dice rolls (1 to 6)
            for (int i = 1; i <= 6; i++) {
                int newPos = pos + i;

                if (newPos > n * n) {
                    continue;  // Skip if out of bounds
                }

                // Check if the square has a snake or ladder
                if (board1D[newPos] != -1) {
                    newPos = board1D[newPos];  // Move to the destination of the snake/ladder
                }

                // If the new position has not been visited, enqueue it
                if (!visited[newPos]) {
                    visited[newPos] = true;
                    queue.add(new int[]{newPos, moves + 1});
                }
            }
        }

        return -1;  // If unreachable
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };

        System.out.println(sol.snakesAndLadders(board));  // Expected output: minimum throws required
    }
}
