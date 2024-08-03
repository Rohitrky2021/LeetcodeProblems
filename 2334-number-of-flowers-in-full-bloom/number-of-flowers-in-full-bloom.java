class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);
        
        Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        
        Map<Integer, Integer> dic = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        int i = 0;
        for (int person : sortedPeople) {
            while (i < flowers.length && flowers[i][0] <= person) {
                heap.add(flowers[i][1]);
                i++;
            }
            
            while (!heap.isEmpty() && heap.peek() < person) {
                heap.remove();
            }
            
            dic.put(person, heap.size());
        }
        
        int[] ans = new int[people.length];
        for (int j = 0; j < people.length; j++) {
            ans[j] = dic.get(people[j]);
        }
        
        return ans;
    }


    public int countFlowers(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0 || k <= 0) {
            return 0;
        }
        int n = flowers.length;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (days[j] - days[i] > k) {
                    break;
                }
                if (days[j] - days[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}


