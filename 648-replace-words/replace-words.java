import java.util.HashSet;
import java.util.List;

class Solution {
    public String replaceWords(List<String> dict, String s) {
        TreeSet<String> hs = new TreeSet<>(dict);
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");

        for (String word : words) {
            String replacement = word;
            for (String prefix : hs) {
                if (word.startsWith(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(replacement);
        }

        return result.toString();
    }
}
