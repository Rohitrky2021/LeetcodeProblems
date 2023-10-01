class Solution {
 public int totalFruit(int[] fruits) {
        int[] fruitCount = new int[fruits.length];
        int tail = 0, ans = 0, distinctFruits = 0;

        Deque<Integer> fruitQueue = new ArrayDeque<>();

        for (int head = 0; head < fruits.length; head++) {
            int currentFruit = fruits[head];

            if (fruitCount[currentFruit] == 0) {
                distinctFruits++;
            }

            fruitCount[currentFruit]++;
            fruitQueue.offerLast(currentFruit);

            // Check if the window needs adjustments to have at most two types of fruit
            while (distinctFruits > 2) {
                int leftFruit = fruitQueue.pollFirst();
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

//     public int totalFruit(int[] fruits) {
//         int[] fruitCount = new int[fruits.length];
//         int tail = 0, ans = 0, distinctFruits = 0;

//         for (int head = 0; head < fruits.length; head++) {
//             int currentFruit = fruits[head];
            
//             if (fruitCount[currentFruit] == 0) {
//                 distinctFruits++;  // For map size as array m direct nhi aayega size
//             }
            
//             fruitCount[currentFruit]++;

//             // Check if the window needs adjustments to have at most two types of fruit
//             while (distinctFruits > 2 && tail < fruits.length) {
//                 int leftFruit = fruits[tail];
//                 fruitCount[leftFruit]--;

//                 // onnly below line for manageing size 
//                 if (fruitCount[leftFruit] == 0) {
//                distinctFruits--; // Size waapis zero hoga tho distinct elemt ka count faaltu m next loop m increase hoga for same element   
//                }
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




