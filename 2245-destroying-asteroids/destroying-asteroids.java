import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {

        long ans = 0 , n = ast.length;
        Arrays.sort(ast);
        if ( ast[0] > mass) return false;
        long[] pre = new long[(int)n + 1];
        pre[0] = ast[0] + mass;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + ast[i];
        }
        boolean flag = true;

        for (int i = 1; i < n; i++) {
            if (ast[i] > pre[i - 1] && ast[i] > mass) {
                flag = false;
                System.out.println(ast[i] + " " + pre[i - 1]);
            }
        }
        return flag;
    }
}
