/**
 * @param {string} s
 * @return {boolean}
 */
var areOccurrencesEqual = function(s) {
    const ALPHABET_SIZE = 26;
    let freq = new Array(ALPHABET_SIZE).fill(0); // Frequency array to store character counts

    // Count the frequency of each character in the string
    for (let i = 0; i < s.length; i++) {
        const index = s.charCodeAt(i) - 'a'.charCodeAt(0); // Get the index for the character
        freq[index]++;
    }

    // Find the frequency of the first character
    let targetFrequency = -1;
    for (let i = 0; i < ALPHABET_SIZE; i++) {
        if (freq[i] > 0) {
            targetFrequency = freq[i];
            break;
        }
    }

    // Check if all non-zero frequencies are the same
    for (let i = 0; i < ALPHABET_SIZE; i++) {
        if (freq[i] > 0 && freq[i] !== targetFrequency) {
            return false;
        }
    }

    return true;
};