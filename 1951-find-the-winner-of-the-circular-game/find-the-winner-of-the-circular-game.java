 
//  TRicky way 
 class Solution {
    public int findTheWinner(int n, int k) {
        if (k == 1) return n;

        int winner = 0;
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        
        return winner + 1;
    }
}

 
 
 
 class Solution2 {
    public int findTheWinner(int n, int k) {
        if(k==1)return n;
        int freq[] = new int[n];
        int lasti = 0;
        int check = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            freq[i] = 0;  // Initialize freq array with 0
        }

        while (check != n - 1) {
            count = 0;

            while (count < k) {
                if (freq[lasti] == 0) {
                    count++;
                }
                if(count==k) freq[lasti]++;
                lasti = (lasti + 1) % n;
            }

            check++;
        }

        for (int i = 0; i < n; i++) {
            if (freq[i] == 0) {
                return i+1 ;
            }
        }

        return -1;  // In case something goes wrong
    }
}



// 1 2 3 4 5
// 2 4 6 8 10

// 2 4 1 3 5
