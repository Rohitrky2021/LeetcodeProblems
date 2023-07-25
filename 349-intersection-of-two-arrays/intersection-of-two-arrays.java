class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
                HashSet<Integer> ans = new HashSet<>();


        if (nums1.length < nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                hs.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (hs.contains(nums2[i])) {
                    ans.add(nums2[i]);
                }else{
                    hs.remove(nums2[i]);
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                hs.add(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                if (hs.contains(nums1[i])) {
                    ans.add(nums1[i]);
                }else{
                    hs.remove(nums1[i]);
                }
            }
        }

        int arr[]=ans.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}
