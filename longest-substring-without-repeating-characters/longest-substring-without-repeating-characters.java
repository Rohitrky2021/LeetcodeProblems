import java.util.HashSet;
import java.util.Set;

class Solution {
public int lengthOfLongestSubstring(String s) {
boolean[] flag = new boolean[256];
int result = 0;
int start = 0;
char[] arr = s.toCharArray();
for (int i = 0; i < arr.length; i++) {
char current = arr[i];
if (flag[current]) {
result = Math.max(result, i - start);
// the loop update the new start point
// and reset flag array
// for example, abccab, when it comes to 2nd c,
// it update start from 0 to 3, reset flag for a,b
for (int k = start; k < i; k++) {
if (arr[k] == current) {
start = k + 1;
break; }
flag[arr[k]] = false; } } else {
flag[current] = true; } }
result = Math.max(arr.length - start, result);
return result;
}
}
