/**
 * @param {string} s1
 * @param {string} s2
 * @return {string[]}
 */
var uncommonFromSentences = function(s1, s2) {
     // Use a Map to count occurrences of words from both sentences
    const wordCount = new Map();

    // Split both sentences into words
    const st1 = s1.split(" ");
    const st2 = s2.split(" ");

    // Count occurrences from first sentence
    st1.forEach(word => {
      wordCount.set(word, (wordCount.get(word) || 0) + 1);
    });

    // Count occurrences from second sentence
    st2.forEach(word => {
      wordCount.set(word, (wordCount.get(word) || 0) + 1);
    });

    // Collect the words that appear exactly once
    const result = [];
    wordCount.forEach((count, word) => {
      if (count === 1) {
        result.push(word);
      }
    });

    // Return the result array
    return result;
};

 
