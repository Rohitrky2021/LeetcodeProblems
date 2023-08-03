class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = num.length;
        int carry = 0;
        int i = n - 1;
        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            list.add(sum % 10);
            carry = sum / 10;
            i--;
        }
        Collections.reverse(list);
        return list;
    }
}
