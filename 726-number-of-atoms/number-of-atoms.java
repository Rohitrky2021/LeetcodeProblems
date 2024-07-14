 import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> current = new HashMap<>();
        int i = 0;
        int n = formula.length();
        
        while (i < n) {
            char c = formula.charAt(i);
            
            if (c == '(') {
                stack.push(current);
                current = new HashMap<>();
                i++;
            } else if (c == ')') {
                int iStart = ++i;
                int multiplicity = 1; // default multiplicity
                
                // Parse multiplicity after ')'
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > iStart) {
                    multiplicity = Integer.parseInt(formula.substring(iStart, i));
                }
                
                // Multiply all elements in current by multiplicity
                if (!stack.isEmpty()) {
                    Map<String, Integer> temp = current;
                    current = stack.pop();
                    for (String key : temp.keySet()) {
                        current.put(key, current.getOrDefault(key, 0) + temp.get(key) * multiplicity);
                    }
                }
            } else {
                int iStart = i;
                i++;
                // Parse element name
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(iStart, i);
                
                // Parse element count
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = (i > iStart) ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                
                // Add element count to current map
                current.put(element, current.getOrDefault(element, 0) + count);
            }
        }
        
        // Convert map to sorted list and construct result string
        StringBuilder result = new StringBuilder();
        List<String> elements = new ArrayList<>(current.keySet());
        Collections.sort(elements);
        
        for (String element : elements) {
            result.append(element);
            int count = current.get(element);
            if (count > 1) {
                result.append(count);
            }
        }
        
        return result.toString();
    }
}
