class Solution {
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