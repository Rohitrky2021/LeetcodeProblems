import java.util.*;

class Solution {

    public int[] sortByBits(int[] arr) {
        // Convert the primitive int array to an Integer array
        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Define a custom comparator using a lambda function
        Comparator<Integer> bitComparator = (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);

            // If the number of set bits is the same, compare the integers themselves
            if (bitCountA == bitCountB) {
                return a - b;
            }

            // Otherwise, sort by the number of set bits
            return bitCountA - bitCountB;
        };

        // Sort the Integer array using the custom comparator
        Arrays.sort(integerArr, bitComparator);

        // Convert the sorted Integer array back to a primitive int array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerArr[i];
        }

        return arr;
    }
}
