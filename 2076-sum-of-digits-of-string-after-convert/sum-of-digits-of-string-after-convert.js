/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLucky = function(s, k) {
     let numStr = "";
        for (let i = 0; i < s.length; i++) {
            numStr += (s.charCodeAt(i) - 'a'.charCodeAt(0) + 1);
        }

        // Convert the string to the sum of its digits k times
        while (k-- > 0) {
            let sum = 0;
            for (let i = 0; i < numStr.length; i++) {
                sum += parseInt(numStr[i]);
            }
            numStr = sum.toString();
        }

        return parseInt(numStr);
};

 