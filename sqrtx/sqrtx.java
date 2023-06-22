class Solution {
    public int mySqrt(int x) {
        return  (int) Math.sqrt(x);
    }
}

import java.util.*;


class Solution {
    public int mySqrt(int x) {

        long right, left;
        long newX = x;

        left = 0;
        right = x;
    


        while (left <= right) {

            long mid = (left + right) / 2;

            if (mid * mid == newX) {
                return (int)mid;
            } else if (mid * mid > newX) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("left = " + left + " right = " + right);

        return (int)right;
        
        // 제곱근을 반내림한 정수를 구해라.
        // 제곱급에서 바로 밑 정수 구하기
        // 제곱근 구하기
            // 두번 곱했을 때 지금 수가 되는 것.
            // 두번 곱했을 떄 지금 수가 되는 수를 찾기.
                // 두번 곱했을 때 지금 수보다 크면 하나 낮추기 
                // 두번 곱했을 떄 지금 수보다 작으면 하나 높이기
                // 하나씩 하면 오래걸림. 수평선 위에서 찾는 거니가 이분 탐색이 가능. 
                // 시간 복잡도를 줄일 수 있다. 
                    // 판결 조건은 두번 곱했을 때 해당 수인지 아닌지
                    // 
        // 바로 밑 정수 구하기

    }
}
