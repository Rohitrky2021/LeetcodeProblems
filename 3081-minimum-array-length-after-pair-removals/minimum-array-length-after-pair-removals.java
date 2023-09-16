     class Solution {
         public int minLengthAfterRemovals(List<Integer> nums) {
           int len = nums.size();
           int ans = nums.size(), i = 0, j = (len + 1) / 2;
           while(i < len/ 2 && j < len) {
           if (nums.get(i) < nums.get(j)) {
               ans-=2;
           }
          i++;
          j++;
       }
      return ans;
      }
   }

//    class Solution {
//     public int minLengthAfterRemovals(List<Integer> nums) {
//         int n = nums.size();
//         if (n==1) return 1;
        
//         int d = n/2, ans = 0, j=d;
//         if (n%2!=0) {
//             ans = ans + 1;
//             j = d+1;
//         }

//         //i for the first half and j for the second half
//         for (int i=0; i<d; i++) {
//             if ((int)nums.get(i) == (int)nums.get(j)) ans = ans +2;
//             j++;
//         }
        
//         return ans;     
//     }
// }