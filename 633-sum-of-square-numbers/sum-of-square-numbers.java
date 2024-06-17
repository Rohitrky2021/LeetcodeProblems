import java.util.HashMap;

class Solution1 {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            int curr = i * i;

            if (hm.containsKey(curr)) {
                return true;
            }

            hm.put(c - curr, i);
        }

        for (int i = 0; i <= n; i++) {
            int curr = i * i;

            if (hm.containsKey(curr)) {
                if (hm.get(curr) != i || curr + curr == c) {
                    return true;
                }
            }
        }

        return false;
    }
}


class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);

        while (left <= right) {
            long sum =(long)  left * left + (long)  right * right;
                        // long sum = (long) i*i + (long) j*j;

            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        
        return false;
    }
}


class Solution3 {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            if (c % i == 0) {
                int count = 0;
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
