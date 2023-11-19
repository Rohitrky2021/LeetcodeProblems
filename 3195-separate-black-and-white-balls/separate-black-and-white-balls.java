public class Solution {
    public long minimumSteps(String s) {
        char a[] = s.toCharArray();
        long sum = calculateSum(a);
        System.out.println(sum);
        return sum;
    }

    public static long calculateSum(char a[]) {
        int onesToLeft = 0;
        long sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '0') {
                sum += onesToLeft;
            } else {
                onesToLeft++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumSteps("110101");
    }
}
