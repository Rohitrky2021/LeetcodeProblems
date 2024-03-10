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
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                hs.add(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                if (hs.contains(nums1[i])) {
                    ans.add(nums1[i]);
                }
            }
        }

        int arr[]=ans.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }


//     class Solution {
//   public int[] intersection(int[] nums1, int[] nums2) {
//     HashSet<Integer> set1 = new HashSet<Integer>();
//     for (Integer n : nums1) set1.add(n);
//     HashSet<Integer> set2 = new HashSet<Integer>();
//     for (Integer n : nums2) set2.add(n);

//     set1.retainAll(set2);-------------------------<<<<<<<<<<<<<<<<<<<<<<<<,

//     int [] output = new int[set1.size()];
//     int idx = 0;
//     for (int s : set1) output[idx++] = s;
//     return output;
//   }
// }
}
