public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed=reversed<<1; // Left shift the result to make space for the next bit
            reversed |= n & 1; // Add the least significant bit of 'n' to the result
            n >>= 1; // Right shift 'n' to process the next bit
        }
        return reversed;
    }
}


 class Solution1 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
        }
        return ans;
    }
}


//    int ans = 0;
//     for(int i=0;i<32;i++){
//         int lsb = n & 1 ;
//         int temp= lsb<<(31-i);
//         ans = ans|temp;
//         n = n>>1;
//     }
//     return ans;
// }