import java.util.HashSet;

class Solution1 {

    static HashSet<String> s;

    public String findDifferentBinaryString(String[] nums) {
        String str = nums[0], ans = "";

        s = new HashSet<>();
        for (String c : nums)
            s.add(c);

        return perm(str, ans);

    }

    public static String perm(String str, String ans) {
        if (str.length() == 0) {
            if (!s.contains(ans)) {
                return ans;
            }
    
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i + 1);

            String result = perm(newstr, ans + curr);
            if (result != null) {
                return result; // Return as soon as a valid string is found
            }
        }
        return null;
    }
}


class Solution2 {
    int n;
    Set<String> numsSet = new HashSet();
    
    private String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }
            
            return "";
        }
        
        String addZero = generate(curr + "0");
        if (addZero.length() > 0) {
            return addZero;
        }
        
        return generate(curr + "1");
    }
    
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        for (String s : nums) {
            numsSet.add(s);
        }
        
        return generate("");
    }
}


class Solution3 { // Iterate Over Integer Equivalents
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        
        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while (ans.length() < n) {
                    ans = "0" + ans;
                }
                
                return ans;
            }
        }
        
        return "";
    }
}


class Solution4 { // Random
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        
        int ans = Integer.parseInt(nums[0], 2);
        int n = nums.length;
        Random rand = new Random();
        
        while (integers.contains(ans)) {
            ans = rand.nextInt((int) Math.pow(2, n));
        }

        String s = Integer.toBinaryString(ans);
        while (s.length() < n) {
            s = "0" + s;
        }
        
        return s;
    }
}


class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }
        
        return ans.toString();
    }
}