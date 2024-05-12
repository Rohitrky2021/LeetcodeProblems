class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        
        List<Pair<Double, Integer>> wageToQualityRatioList = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i++) {
            wageToQualityRatioList.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }
        
        Collections.sort(wageToQualityRatioList, (x, y) -> Double.compare(x.getKey(), y.getKey()));
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        
        
        int curTotalQuality = 0;
        int curQuality = 0;
        
        for (int i = 0 ; i < k ; i++) {
            curQuality = wageToQualityRatioList.get(i).getValue();
            maxHeap.add(curQuality);
            curTotalQuality += curQuality;
        }
        
        double curRatio = wageToQualityRatioList.get(k-1).getKey();
        double ans = curTotalQuality * curRatio;
        
        for (int i = k ; i < n ; i++) {
            curRatio = wageToQualityRatioList.get(i).getKey();
            curQuality = wageToQualityRatioList.get(i).getValue();
            
            maxHeap.add(curQuality);
            curTotalQuality += curQuality - maxHeap.poll();
            ans = Math.min(ans, curTotalQuality * curRatio);
        }
        
        return ans;
    }
}

// Time : O(nlogn) ~ O(nlogn + nlogk), nlogn for sorting and nlogk while forming the heap
// Space : O(n) ~ O(n + k), 


// class Worker {
//     int quality;
//     int wage;

//     public Worker(int quality, int wage) {
//         this.quality = quality;
//         this.wage = wage;
//     }
// }

// class Solution {
//     public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//         int n = quality.length;
//         Worker[] workers = new Worker[n];

//         for (int i = 0; i < n; i++) {
//             workers[i] = new Worker(quality[i], wage[i]);
//         }

//         Arrays.sort(workers, (a, b) -> Double.compare((double) a.wage / a.quality, (double) b.wage / b.quality));

//         double minCost = Double.MAX_VALUE;
//         int workQuality = 0;
//         PriorityQueue<Integer> res = new PriorityQueue<>((a, b) -> b - a);

//         for (Worker worker : workers) {
//             workQuality += worker.quality;
//             res.offer(worker.quality);

//             if (res.size() > k) {
//                 workQuality -= res.poll();
//             }

//             if (res.size() == k) {
//                 minCost = Math.min(minCost, workQuality * ((double) worker.wage / worker.quality));
//             }
//         }

//         return minCost;
//     }
// }