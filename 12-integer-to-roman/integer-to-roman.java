class Solution {
        private  final TreeMap<Integer, String> romanMap = new TreeMap<>();

         {
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
        }

    public String intToRoman(int num) {
        return  toRoman(num);

    }

      public  String toRoman(int number) {
        int floorKey = romanMap.floorKey(number);
        if (number == floorKey) {
            return romanMap.get(number);
        }
        return romanMap.get(floorKey) + toRoman(number - floorKey);
    }
}

  