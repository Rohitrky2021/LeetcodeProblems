class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((s, t) -> (t + s).compareTo(s + t));
        for (int s : nums) pq.offer(Integer.toString(s));
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        int zero = 0;
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            else break;
        }
        s = s.substring(zero);
        return s.length() > 0 ? s : "0";
    }
}