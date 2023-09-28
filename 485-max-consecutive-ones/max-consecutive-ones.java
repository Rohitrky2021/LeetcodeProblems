// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int max=0,ans=0;
//         for(int i:nums){
//             if(i==0)max=0;
//             else  ans=Math.max(++max,ans);;

         

//         }
//         return ans;
//     }
// }


class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int ans = 0;
    int sum = 0;

    for (final int num : nums)
      if (num == 1)
        ans = Math.max(ans, ++sum);
      else
        sum = 0;

    return ans;
  }
}

