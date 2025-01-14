var findThePrefixCommonArray = function(A, B) {
    let n = A.length;
    let seen = new Set();
    let C = Array(n).fill(0);
    let commonCount = 0;
    for (let i = 0; i < n; i++) {
        if (seen.has(A[i])) commonCount++;
        else seen.add(A[i]);
        if (seen.has(B[i])) commonCount++;
        else seen.add(B[i]);
        C[i] = commonCount;
    }
    return C;
};