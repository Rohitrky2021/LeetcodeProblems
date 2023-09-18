// class Solution {

//     int  dp[]=new int[1005];

// 	public int coinChange(int[] coins, int amount) {
//         if(amount==0) return 0;
//         if(dp[amount]!=-1) return dp[amount];
//         int cc=Integer.MAX_VALUE;
//         int coin=0;
//         for(int i=0;i<coins.length;i++) {
//             if(amount-coins[i]>=0)
//                  cc=Math.min(cc,coinChange(coins, amount-coins[i])+1 );

//         }
//         return dp[amount]=cc;
//     }

// }

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
			return -1;

		if (amount <= 0)
			return 0;

		int dp[] = new int[amount + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int am = 1; am < dp.length; am++) {
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] <= am) {
					int sub = dp[am - coins[i]];
					if (sub != Integer.MAX_VALUE)
						dp[am] = Math.min(sub + 1, dp[am]);
				}
			}
		}
		return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }
}
