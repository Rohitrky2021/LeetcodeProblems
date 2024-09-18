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

class Solution2 {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}