class Solution2 {
    public void rotate(int[] nums, int k) {
        int n=nums.length;

        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[(i+k)%n]=nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }


         
        
    }
}

// Approach 3: Using Cyclic Replacements
class Solution {
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int current = start;
      int prev = nums[start];
      do {
        int next = (current + k) % nums.length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }
}