class Solution1 {
    public int[] singleNumber(int[] nums) {
        int grpA=0;
        int grpB=0;
        int x=0;

        for(int num:nums){
            x^=num;
        }

        // int mask=x&((~x+1));
// or the Above line can also be written as
        int mask=x&(-x);   /// Its the lowest Set bit 


        for(int num:nums){
            if((num & mask)!=0){
                grpA^=num;
            }else{
                grpB^=num;
            }
        } 
       return new int[]{grpA,grpB};
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] bitCount = new int[64];
        long grpA = 0;
        long grpB = 0;
        
        // Step 1: Calculate the XOR of all numbers
        long x = 0;
        for (int num : nums) {
            x ^= num;
        }
        
        // Step 2: Find the lowest set bit in x using the array
        for (int i = 0; i < 64; i++) {
            if ((x & (1L << i)) != 0) {
                bitCount[i] = 1;
                break;
            }
        }
        
        // Step 3: Use the bitCount array to create the mask
        long mask = 0;
        for (int i = 0; i < 64; i++) {
            if (bitCount[i] == 1) {
                mask = 1L << i;
                break;
            }
        }
        
        // Step 4: Divide the numbers into two groups and XOR within each group
        for (long num : nums) {
            if ((num & mask) != 0) {
                grpA ^= num;
            } else {
                grpB ^= num;
            }
        }
        
        // Return the two unique numbers
        return new int[]{(int)grpA, (int)grpB};
    }
}


class Solution3 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                res[index++] = entry.getKey();
                if (index == 2) {
                    break;
                }
            }
        }

        return res;
    }
}
