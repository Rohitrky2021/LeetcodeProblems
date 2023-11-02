class Solutionn {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int prefixMod = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num: nums) {
            // Take modulo twice to avoid negative remainders.
            prefixMod = (prefixMod + num % k + k) % k;
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    
    }
}


class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] countMods = new int[k];
        int result = 0;

        prefixSum[0] = nums[0] % k;
        if (prefixSum[0] < 0) {
            prefixSum[0] += k; // Ensure positive remainder
        }
        countMods[prefixSum[0]]++;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = (prefixSum[i - 1] + nums[i]) % k;
            if (prefixSum[i] < 0) {
                prefixSum[i] += k; // Ensure positive remainder
            }
            countMods[prefixSum[i]]++;
        }

        for (int count : countMods) {
            if (count > 1) {
                result += count * (count - 1) / 2; // Calculate the number of combinations
            }
        }

        result += countMods[0]; // Add subarrays starting from the beginning with a remainder of 0

        return result;
    }
    public int subarraysDivByKk(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;  // let (-5+3)-->-2  Mod also no effect --> -2%5 ==> -2 so we add K agin -2+5==> 3
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
} 

class Solutionnn {
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
		map[0] = 1;
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}

class Solutionnnn {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans=0;
        HashMap<Integer,Integer>mp = new HashMap<>();
        int sum=0;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int divisor = sum%k;
            if(divisor<0){
                divisor+=k;
            }
            if(mp.containsKey(divisor)){
                ans+=mp.get(divisor);
                mp.put(divisor,mp.get(divisor)+1);
            }else{
                mp.put(divisor,1);
            }
        }
        return ans;
    }
}