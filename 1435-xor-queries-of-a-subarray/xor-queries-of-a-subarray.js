/**
 * @param {number[]} arr
 * @param {number[][]} queries
 * @return {number[]}
 */
var xorQueries = function(arr, queries) {
    const n = arr.length;

        let x = new Array(n);
        let ans = new Array(queries.length);

        x[0] = arr[0];
        for (let i = 1; i < n; i++) {
            x[i] = arr[i] ^ x[i - 1];
        }

        let i = 0;
        for (let q of queries) {
            const l = q[0];
            const r = q[1];
            if (l - 1 >= 0) {
                ans[i++] = x[l - 1] ^ x[r];
            } else {
                ans[i++] = x[r];
            }
        }

        return ans;
};