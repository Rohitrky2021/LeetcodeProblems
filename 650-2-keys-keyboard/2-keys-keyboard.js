const memo = new Map();

const minSteps = function(n) {
    // Base case: If we already have 1 'A', no more steps are needed
    if (n === 1) return 0;

    // Check if the result is already computed
    if (memo.has(n)) return memo.get(n);

    // Initialize the minimum steps to n (worst case)
    let steps = n;

    // Try all divisors of n
    for (let i = Math.floor(n / 2); i >= 1; i--) {
        if (n % i === 0) {  // i is a divisor of n
            // Recursively solve the subproblem and update the minimum steps
            steps = Math.min(steps, minSteps(i) + (n / i));
            break;
        }
    }

    // Memoize the result
    memo.set(n, steps);
    return steps;
};

// Example usage:
console.log(minSteps(9)); // Output: 6
