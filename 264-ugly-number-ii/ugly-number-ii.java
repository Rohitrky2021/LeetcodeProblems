class Solution1 {
    public int nthUglyNumber(int n) {
        if (n <= 0)  return 0; // Edge case
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));  //current min we got 

            // store the ith min ans
            uglyNumbers[i] = min;
            
            // checks to perform the necxt operation
            if (min == factor2) {
                index2++; // Number of times apna min fact 2 aaaya tha 
                factor2 = 2 * uglyNumbers[index2];
            }
            if (min == factor3) {
                index3++;
                factor3 = 3 * uglyNumbers[index3];
            }
            if (min == factor5) {
                index5++;
                factor5 = 5 * uglyNumbers[index5];
            }
        }
        return uglyNumbers[n - 1];
    }
}

// --------------------------------------------------------------=============================>>>>>>>>>>>>>>
class Ugly{
public int[] nums = new int[1690];
Ugly(){
    nums[0] = 1;
    int ugly,i2 = 0,i3=0,i5=0;

    for(int i=1;i<1690;i++){
        ugly = Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
        nums[i] = ugly;

        if(ugly == nums[i2]*2) ++i2;
        if(ugly == nums[i3]*3) ++i3;
        if(ugly == nums[i5]*5) ++i5;
        
    }
}
}
class Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n-1];
    }
}

// --------------------------------------------------------------=============================>>>>>>>>>>>>>>


class Solution2 {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int p2Val = dp[p2] * 2;
            int p3Val = dp[p3] * 3;
            int p5Val = dp[p5] * 5;
            int currentUglyNumber = Math.min(p2Val, Math.min(p3Val, p5Val));

            if (currentUglyNumber == p2Val) p2++;
            if (currentUglyNumber == p3Val) p3++;
            if (currentUglyNumber == p5Val) p5++;

            dp[i] = currentUglyNumber;
        }

        return dp[n - 1];
    }
}

// --------------------------------------------------------------=============================>>>>>>>>>>>>>>

// public int nthUglyNumber(int n) {
//         TreeSet<Long> st = new TreeSet<>();
//         st.add((long)1);
//         int cnt = 0;
//         long ans = 1;
//         for(;cnt != n;){
//             long ugly = st.pollFirst();
//             ans = ugly;
//             ++cnt;
//             st.add(2 * ugly);
//             st.add(3 * ugly);
//             st.add(5 * ugly);
//         }
//         return (int)ans;
//     }


// --------------------------------------------------------------=============================>>>>>>>>>>>>>>
