class Solution {
    private static final String[] UNDER_19 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                              "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        int thousandIndex = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, helper(num % 1000) + THOUSANDS[thousandIndex] + " ");
            }
            num /= 1000;
            thousandIndex++;
        }

        return result.toString().trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return UNDER_19[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + (num % 10 != 0 ? " " + UNDER_19[num % 10] : "") + " ";
        } else {
            return UNDER_19[num / 100] + " Hundred " + (num % 100 != 0 ? helper(num % 100) : "");
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = Integer.parseInt(args[0]);
        System.out.println(sol.numberToWords(num));
    }
}
