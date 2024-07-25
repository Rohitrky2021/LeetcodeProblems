class Solutions {
    public int[] sortArray(int[] nums) {

        int i=0;
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) pq.offer(num);
        while(!pq.isEmpty()) ans[i++] = pq.poll();
        return ans;
    }
}

class Solution {
    public int[] sortArray(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if(max<a[i]){
                max = a[i];
            }
        }
        for (int i = 1; i < a.length; i++) {
            if(min>a[i]){
                min = a[i];
            }
        }
        int[] count = new int[max-min+1];  
        // Till now was just to get the length for the Array suing Min max 

        for(int v:a){
            count[v-min]++;  // making it 0 beased indx but making min as 1st number 
        }
        int k=0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0){
                a[k] = i+min; //again increase it to original 
                k++;
                count[i]--;
            }
        }
        return a;
    }

}