class Solution1 {
    public boolean uniqueOccurrences(int[] arr) {
        int f[] = new int[2020];

        Arrays.fill(f, Integer.MAX_VALUE);

        for (int i = 0; i < arr.length; i++) {
            f[arr[i] + 1000]++;
        }

        Arrays.sort(f);

        for (int i = 1; i < f.length; i++) {
            if(f[i]!=Integer.MAX_VALUE && f[i]==f[i-1])return false;
        }
        return true;

    }
}

// import java.util.HashSet;
// import java.util.Set;

class Solution {
    private static final int OFFSET = 1000;

    public boolean uniqueOccurrences(int[] arr) {
        int[] f = new int[2020];

        for (int num : arr) {
            f[num + OFFSET]++;
        }

        Set<Integer> occurrencesSet = new HashSet<>();

        for (int count : f) {
            if (count != 0) {
                if (!occurrencesSet.add(count)) {
                    return false;
                }
            }
        }

        return true;
    }
}
