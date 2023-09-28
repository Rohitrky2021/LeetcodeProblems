class Solution {

    // main hook of COnitnuos is ==>  exactly one subarray.  &&  unique elements-->tell us to use hashmap for freq

    public int maximumUniqueSubarray(int[] arr) { //using video template
        HashMap<Integer, Integer> hm = new HashMap<>();

        int tail = 0, ans = 0, sum = 0, head/*makeing it global */;

        for (head = 0; head < arr.length; head++) {
            hm.put(arr[head], hm.getOrDefault(arr[head], 0) + 1);

            while (hm.getOrDefault(arr[head], 0) > 1) {
                ans = Math.max(ans, sum);
                sum = sum - arr[tail];
                hm.put(arr[tail], hm.getOrDefault(arr[tail], 0) - 1);
                tail++;
            }

            // if(hm.getOrDefault(arr[head], 0)==1)
            sum += arr[head];
            
            // ans = Math.max(ans, sum);
        }

        // return head-tail+1;
        return  Math.max(ans, sum);
    }
}
