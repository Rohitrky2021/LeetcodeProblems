class Solution1 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        
        Map<Integer, List<Integer>> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return steps;
                }
                
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
                
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }
                
                for (int index : valueToIndex.getOrDefault(arr[curr], Collections.emptyList())) {
                    if (!visited[index]) {
                        visited[index] = true;
                        queue.offer(index);
                    }
                }
                
                // remove the indices with the same value to avoid revisiting them
                valueToIndex.remove(arr[curr]);
            }
            steps++;
        }
        
        return -1;
    }
}

 
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0; // Already at the last index

        // Map to store indices with the same value
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        // Initialize DP array and BFS queue
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE); // Use MAX_VALUE as initial value
        dp[0] = 0; // Starting point
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int steps = dp[index];

            // Move to index + 1
            if (index + 1 < n && dp[index + 1] > steps + 1) {
                dp[index + 1] = steps + 1;
                queue.add(index + 1);
            }

            // Move to index - 1
            if (index - 1 >= 0 && dp[index - 1] > steps + 1) {
                dp[index - 1] = steps + 1;
                queue.add(index - 1);
            }

            // Move to all indices with the same value
            if (valueToIndices.containsKey(arr[index])) {
                for (int j : valueToIndices.get(arr[index])) {
                    if (dp[j] > steps + 1) {
                        dp[j] = steps + 1;
                        queue.add(j);
                    }
                }
                // Clear the list to prevent redundant future checks
                valueToIndices.remove(arr[index]);
            }
        }

        // Return the result for the last index
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}
