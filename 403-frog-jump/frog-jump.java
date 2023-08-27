// class Solution {
//     public boolean canCross(int[] stones) {
//         int N = stones.length;
//         boolean[][] dp = new boolean[N][N + 1];
//         dp[0][1] = true;
        
//         for(int i = 1; i < N; ++i){
//             for(int j = 0; j < i; ++j){
//                 int diff = stones[i] - stones[j];
//                 if(diff < 0 || diff > N || !dp[j][diff]) continue;
//                 dp[i][diff] = true;
//                 if(diff - 1 >= 0) dp[i][diff - 1] = true;
//                 if(diff + 1 <= N) dp[i][diff + 1] = true;
//                 if(i == N - 1) return true;
//             }
//         }

//         return false;
//     }
// }

class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> dset = new HashSet<>();
        dset.add(0);
        map.put(0,dset);

        for(int stone : stones){
            if(!map.containsKey(stone)) continue;
            HashSet<Integer> set = map.get(stone);
            
            for(int num : set){
                for(int i = -1; i <= 1; i++){
                    int next = num + i + stone;
                    if(stone < next && next <= stones[stones.length-1]){
                        HashSet<Integer> nset = map.getOrDefault(next, new HashSet<>());
                        nset.add(next - stone);
                        map.put(next, nset);
                    }
                }
            }
        }

        return map.containsKey(stones[stones.length-1]);
    }
}