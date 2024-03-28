class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
      HashMap<Integer,Integer> st= new HashMap<Integer,Integer>();
       int maxLength = 0;
       int left = 0;

        for (int right = 0; right < nums.length; right++) {

           int x=nums[right];

           while(st.containsKey(x) && st.get(x)>=k){
              st.put(nums[left], st.get(nums[left])-1);
              left++;
            }
            
           st.put(x,st.getOrDefault(x,0)+1);
            maxLength = Math.max(maxLength, right-left+1);
            System.out.println(maxLength);
           

        }

        return maxLength;


        
    }

    
}