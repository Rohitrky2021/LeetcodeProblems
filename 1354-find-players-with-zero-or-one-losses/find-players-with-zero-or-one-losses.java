// class Solution2 {
//     public List<List<Integer>> findWinners(int[][] matches) {
        
//     }
// }

 

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> winnersFirstColumn = new ArrayList<>();
        List<Integer> winnersSecondColumn = new ArrayList<>();

        int[] frequencyFirstColumn = new int[100001];
        int[] frequencySecondColumn = new int[100001];

        // Count the frequency of each element in the second column
        for (int[] match : matches) {
            frequencySecondColumn[match[1]]++;
        }

        // Find winners in the first column
        for (int[] match : matches) {
            frequencyFirstColumn[match[0]]++;
            if (frequencySecondColumn[match[0]] == 0) {
                winnersFirstColumn.add(match[0]);
            }
        }

        // Sort and make winnersFirstColumn unique
        Set<Integer> uniqueSortedWinnersFirstColumn = new TreeSet<>(winnersFirstColumn);

        // Find winners in the second column
        for (int i = 1; i <= 100000; i++) {
            if (frequencySecondColumn[i] == 1) {
                winnersSecondColumn.add(i);
            }
        }

        ans.add(new ArrayList<>(uniqueSortedWinnersFirstColumn));
        ans.add(winnersSecondColumn);

        return ans;
    }
}

 
 

class Solution2 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> winnersFirstColumn = new ArrayList<>();
        List<Integer> winnersSecondColumn = new ArrayList<>();
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();

        // Count the frequency of each element in the second column
        for (int[] match : matches) {
            frequencyMap.put(match[1], frequencyMap.getOrDefault(match[1], 0) + 1);
        }

        // Find winners in the first column
        for (int[] match : matches) {
            if (!frequencyMap.containsKey(match[0])) {
                winnersFirstColumn.add(match[0]);
            }
        }

        // Sort and make winnersFirstColumn unique
        Set<Integer> uniqueSortedWinnersFirstColumn = new TreeSet<>(winnersFirstColumn);

        // Find winners in the second column
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == 1) {
                winnersSecondColumn.add(key);
            }
        }

        ans.add(new ArrayList<>(uniqueSortedWinnersFirstColumn));
        ans.add(winnersSecondColumn);

        return ans;
    }
}
