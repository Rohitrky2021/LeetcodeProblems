class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q=new PriorityQueue<>();
        int count=0;

        for (int i = 0; i < nums.length; i++) {
            q.add((long)nums[i]);
        }

        while (q.peek()<k && q.size()>=2) {
            long x=q.poll();
            long y=q.poll();

            q.add(Math.min(x, y)*2+Math.max(x, y));
            count++;
        }
        System.out.println(q);
        return count;
        
    }
}