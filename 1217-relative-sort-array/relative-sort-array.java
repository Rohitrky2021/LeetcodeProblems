class Solution1 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int freq[]=new int[1005];

        for(int i=0;i<arr1.length;i++){
            freq[arr1[i]]++;
        }

        int j=0;
        for(int i=0;i<arr2.length;i++){
            if(freq[arr2[i]]!=0){
                while(freq[arr2[i]]!=0){
                    arr1[j++]=arr2[i];
                    freq[arr2[i]]--;
                }
            }
        }

         for(int i=0;i<1001;i++){
            if(freq[i]!=0){
                while(freq[i]!=0){
                    arr1[j++]=i;
                    freq[i]--;

                }
            }
        }

        return arr1;
        
    }
}
 
class Solution2 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Initialize count map with relative order elements
        for (int value : arr2) {
            countMap.put(value, 0);
        }

        // Count occurrences of elements in target array
        for (int value : arr1) {
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                remaining.add(value);
            }
        }

        // Sort the remaining elements
        Collections.sort(remaining);

        // Add elements as per relative order
        for (int value : arr2) {
            for (int j = 0; j < countMap.get(value); j++) {
                result.add(value);
            }
        }

        // Add remaining elements
        result.addAll(remaining);

        // Convert ArrayList to array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
 
class Solution3 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Convert arr1 to an Integer array
        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        
        // Create a map to store the rank of each element in arr2
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            rankMap.put(arr2[i], i);
        }

        // Sort arr1 using a custom comparator
        Arrays.sort(arr1Integer, (a, b) -> {
            if (rankMap.containsKey(a) && rankMap.containsKey(b)) {
                return rankMap.get(a) - rankMap.get(b);
            } else if (rankMap.containsKey(a)) {
                return -1;
            } else if (rankMap.containsKey(b)) {
                return 1;
            } else {
                return Integer.compare(a, b);
            }
        });

        // Convert arr1Integer back to an int array
        return Arrays.stream(arr1Integer).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = solution.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
 Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            indexMap.put(arr2[i], i);
        }

        return Arrays.stream(arr1)
                .boxed()
                .sorted((a, b) -> {
                    if (indexMap.containsKey(a) && indexMap.containsKey(b)) {
                        return indexMap.get(a) - indexMap.get(b);
                    } else if (indexMap.containsKey(a)) {
                        return -1;
                    } else if (indexMap.containsKey(b)) {
                        return 1;
                    } else {
                        return a - b;
                    }
                })
                .mapToInt(i -> i)
                .toArray();

    }}