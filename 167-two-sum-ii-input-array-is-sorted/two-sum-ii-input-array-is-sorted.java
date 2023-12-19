class Solution {
    public int[] twoSum(int[] array, int target) {
       int lp = 0;
    int rp = array.length - 1;

    while (lp <= rp) {
        if (array[lp] + array[rp] == target) {
            System.out.println("["+(lp+1)+ "," +(rp+1)+"]");
            return new int[]{lp+1,rp+1};
        }

        if (array[lp] + array[rp] > target) {
            rp--;
        } else {
            lp++;
        }
    }  
    return new int[]{};
    }
}

// public static void targetM2(int target, int[] array) {
//     int lp = 0;
//     int rp = array.length - 1;

//     while (lp <= rp) {
//         if (array[lp] + array[rp] == target) {
//             System.out.println(array[lp] + "," + array[rp]);
//         }

//         if (array[lp] + array[rp] > target) {
//             rp--;
//         } else {
//             lp++;
//         }
//     }
// }
