// class Solution {

//     public int totalFruit(int[] fruits) {
//         char si[] = s.toCharArray();
//         int f[] = new int[fruits.length];
//         int tail = 0, ans = 0, head, max = 0;

//         for (head = 0; head < si.length; head++) {
//             f[si[head] - 'A']++;

//             max = Math.max(max, f[si[head] - 'A']); // Global max frew

//             // Check if the window needs adjustments to make it valid
//             while ((head - tail + 1) - max > k) { // getting the count of jinka change krna hai as max waale we dont change
//                 f[si[tail] - 'A']--; // Decrement the frequency count
//                 tail++;
//             }

//             ans = Math.max(ans, head - tail + 1);
//         }

//         return ans;
//     }
// }

// class Solution {

//     public int totalFruit(int[] fruits) {
//         Map<Integer, Integer> fruitCount = new HashMap<>();
//         int tail = 0, ans = 0;

//         for (int head = 0; head < fruits.length; head++) {
//             int currentFruit = fruits[head];
//             fruitCount.put(currentFruit, fruitCount.getOrDefault(currentFruit, 0) + 1);

//             // Check if the window needs adjustments to have at most two types of fruit
//             while (fruitCount.size() > 2 && tail<fruits.length) {
//                 int leftFruit = fruits[tail];
//                 fruitCount.put(leftFruit, fruitCount.getOrDefault(leftFruit,0) - 1); // fr[tail]-
//                 if (fruitCount.get(leftFruit) == 0) {// remove krna pdega or wrong ans 
//                     fruitCount.remove(leftFruit);
//                 }
//                 tail++;
//             }

//             ans = Math.max(ans, head - tail + 1);
//         }

//         return ans;
//     }
// }

class Solution {

    public int totalFruit(int[] fruits) {
        int[] fruitCount = new int[fruits.length];
        int tail = 0, ans = 0, distinctFruits = 0;

        for (int head = 0; head < fruits.length; head++) {
            int currentFruit = fruits[head];
            
            if (fruitCount[currentFruit] == 0) {
                distinctFruits++;
            }
            
            fruitCount[currentFruit]++;

            // Check if the window needs adjustments to have at most two types of fruit
            while (distinctFruits > 2 && tail < fruits.length) {
                int leftFruit = fruits[tail];
                fruitCount[leftFruit]--;
                if (fruitCount[leftFruit] == 0) {
                    distinctFruits--;
                }
                tail++;
            }

            ans = Math.max(ans, head - tail + 1);
        }

        return ans;
    }
}


