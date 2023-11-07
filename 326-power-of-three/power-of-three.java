class Solution {

    public boolean isPowerOfThree(int n) {
        return (n <= 0) ? false : (n == 1) ? true : (n % 3 == 0) ? isPowerOfThree(n / 3) : false;
    }

    public boolean oisPowerOfThree(int n) {
        //             Let's see for power=1 , below are the bit representations,
        //                                        1      +           10          =                      11
        //                                  (Power(3,0))    +      Left Shift(Power(3,0)) =     Power(3,1)

        //       for power=2 ,               11          +                110           =                    1001
        //                                  (Power(3,1))    +      Left Shift(Power(3,1)) =     Power(3,2)

        //We start with temp=1 because the least power of 3 can be 0
        // So 3^0=1

        long temp = 1;
        int i = 1;
        while (n > 1 && temp < n) {
            temp += temp << 1;
        }

        return temp == n;
    }
}
