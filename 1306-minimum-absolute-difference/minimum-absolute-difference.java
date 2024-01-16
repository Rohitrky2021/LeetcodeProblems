class Solution {
   public List<List<Integer>> minimumAbsDifference1(int[] arr) {

        // Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(Math.abs(arr[i - 1] - arr[i]), min);
        }

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i - 1] - arr[i]) == min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                ans.add(pair);
            }
        }

        return ans;
    }


     public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];

            if (currentDiff < min) {
                min = currentDiff;
                ans.clear();
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (currentDiff == min) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return ans;
    }


    // public List<List<Integer>> minimumAbsDifferences(int[] arr) {

    //     ArrayList<Integer> a = new ArrayList<>();

    //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    //     int min = Integer.MAX_VALUE;

    //     for (int i = 1; i < arr.length; i++) {
    //         min = Math.min(Math.abs(arr[i - 1] - arr[i]), min);
    //     }

    //     for (int i = 1; i < arr.length; i++) {
    //         if (Math.abs(arr[i - 1] - arr[i]) == min) {
    //             a.add(Math.min(arr[i - 1], arr[i - 1]));
    //             a.add(Math.max(arr[i - 1], arr[i - 1]));

    //         }
    //         ans.add(a);
    //         a.clear();
    //     }


    //     return ans;

    // }
}