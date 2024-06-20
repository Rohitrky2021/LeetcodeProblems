class Solution1 {
    public int numberOfArithmeticSlices(int[] arr) {
        int[] dp = new int[arr.length];
		int ans = 0,check=0;
		
		for(int i = 2; i < arr.length; i++){
		    if(arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]){
		        dp[i] = dp[i - 1] + 1;
		        ans += dp[i];
                check++;
		    }
		}
		System.out.println(check);
		return ans;
    }
}

 
class Solution {
    private int[] dp;

    public int numberOfArithmeticSlices(int[] arr) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);  // Initialize dp array with -1 to denote uncomputed states
        int ans = 0;
        
        for (int i = 2; i < arr.length; i++) {
            ans += countSlices(arr, i);
        }
        
        return ans;
    }

    private int countSlices(int[] arr, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        if (i < 2) {
            return 0;
        }

        if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
            dp[i] = 1 + countSlices(arr, i - 1);
            return dp[i];
        } else {
            dp[i] = 0;
            return 0;
        }
    }

   
}
