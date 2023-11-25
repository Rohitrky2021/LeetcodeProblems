class Solution {
 public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int[] freq = new int[arr.length];
        int rank = 1;

        for (int i = 0; i < sortedArr.length; i++) {
            if (i == 0 || sortedArr[i] != sortedArr[i - 1]) {
                freq[i] = rank++;
            } else {
                freq[i] = freq[i - 1];
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int index = Arrays.binarySearch(sortedArr, arr[i]);
            result[i] = freq[index];
        }

        return result;
    }

}