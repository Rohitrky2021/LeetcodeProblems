class Solution {
    public String[] sortPeople(String[] names, int[] ht) {
        Integer[] indices = new Integer[names.length];
        for (int i = 0; i < names.length; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the corresponding heights in descending order
        Arrays.sort(indices, (a, b) -> ht[b] - ht[a]);

        // Create a new array to store the sorted names
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            sortedNames[i] = names[indices[i]];
        }

        return sortedNames;

    }
}