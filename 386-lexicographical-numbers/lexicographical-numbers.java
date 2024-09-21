import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }

        Collections.sort(ans, (a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));

        return ans;
    }
}
