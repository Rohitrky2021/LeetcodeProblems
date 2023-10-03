class Solution {
//    public String convert(String s, int r) {
//     int dia = r - 2, count = 0;
//     StringBuilder ans = new StringBuilder();
//     char[][] mat = new char[r][1000 * r];

//     // Initialize the matrix with spaces
//     for (int i = 0; i < r; i++) {
//         for (int j = 0; j < 1000 * r; j++) {
//             mat[i][j] = ' ';
//         }
//     }

//     int i = 0, j = 0, m = 0;

//     while (count < s.length()) {
//         // Fill vertically downwards
//         while (i < r && count < s.length()) {
//             mat[i][j] = s.charAt(count++);
//             i++;
//         }
//         i = r - 2; // Reset i for diagonal movement

//         // Fill diagonally upwards
//         while (i >= 1 && j < 1000 * r - 1 && count < s.length()) {
//             mat[i][j + 1] = s.charAt(count++);
//             i--;
//             j++;
//         }

//         // Reset i and j for vertical movement
//         i = 0;
//         j++;

//         // Fill vertically upwards
//         while (i < r && count < s.length()) {
//             mat[i][j] = s.charAt(count++);
//             i++;
//         }
//     }

//     // Construct the result by reading characters from the matrix
//     for (int k = 0; k < r; k++) {
//         for (int l = 0; l < 1000 * r; l++) {
//             if (Character.isLetter(mat[k][l])) {
//                 ans.append(mat[k][l]);
//             }
//         }
//     }

//     return ans.toString();
// }


public String convert(String s, int numRows) {
    if (numRows == 1 || numRows >= s.length()) {
        return s;
    }

    StringBuilder[] rows = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
        rows[i] = new StringBuilder();
    }

    int currentRow = 0;
    boolean goingDown = false;

    for (char c : s.toCharArray()) {
        rows[currentRow].append(c);
        if (currentRow == 0 || currentRow == numRows - 1) {
            goingDown = !goingDown;
        }
        currentRow += goingDown ? 1 : -1;
    }

    StringBuilder result = new StringBuilder();
    for (StringBuilder row : rows) {
        result.append(row);
    }

    return result.toString();
}

}