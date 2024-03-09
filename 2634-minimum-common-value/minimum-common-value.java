class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        HashSet<Integer> s=new HashSet<>();

        for(int x:nums2){
            s.add(x);
        }


        for(int i=0;i<nums1.length;i++){
            if(s.contains(nums1[i]))return nums1[i];
        }


        return -1;
 
    }
}