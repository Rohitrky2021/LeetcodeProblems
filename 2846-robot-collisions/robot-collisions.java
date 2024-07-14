import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        TreeMap<Integer, int[]> robotMap = new TreeMap<>();

        for (int i = 0; i < n; ++i) {
            robotMap.put(positions[i], new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robotMap.values()) {
            if (robot[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L') {
                stack.push(robot);
                continue;
            }

            if (robot[2] == 'L') {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && add) {
                    int last_health = stack.peek()[1];
                    if (robot[1] > last_health) {
                        stack.pop();
                        robot[1] -= 1;
                    } else if (robot[1] < last_health) {
                        stack.peek()[1] -= 1;
                        add = false;
                    } else {
                        stack.pop();
                        add = false;
                    }
                }

                if (add) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(stack);
        resultList.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : resultList) {
            result.add(robot[1]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] positions = {1, 2, 3, 4, 5};
        int[] healths = {10, 20, 30, 40, 50};
        String directions = "RLRLR";
        System.out.println(sol.survivedRobotsHealths(positions, healths, directions));
    }
}
