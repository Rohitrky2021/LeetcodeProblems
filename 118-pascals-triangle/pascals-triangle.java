class Solution {

    public List<List<Integer>> generate(int r) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (r < 0) {
            return triangle;
        }

        for (int i = 0; i < r; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(value);
            }
            if (i > 0) {
                row.add(1);
            }
            triangle.add(row);
        }

        return triangle;
    }
}
