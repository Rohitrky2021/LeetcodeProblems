import java.util.*;

class Solution {

 public int[] sortByBits(int[] arr) {
        // Convert the primitive int array to an Integer array
        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArr[i] = arr[i];
        }

        // Define a custom comparator to compare integers by the number of set bits
        Comparator<Integer> bitComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int bitCountA = Integer.bitCount(a); // Count set bits in 'a'
                int bitCountB = Integer.bitCount(b); // Count set bits in 'b'
                
                // If the number of set bits is the same, compare the integers themselves
                if (bitCountA == bitCountB) {
                    return a - b;
                }
                
                // Otherwise, sort by the number of set bits
                return bitCountA - bitCountB;
            }
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
