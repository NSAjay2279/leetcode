public class Solution {
    /**
     * @param {String} s
     * @return {boolean}
     */
    public boolean areOccurrencesEqual(String s) {
        final int ALPHABET_SIZE = 26;
        int[] freq = new int[ALPHABET_SIZE]; // Frequency array to store character counts

        // Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find the frequency of the first character
        int targetFrequency = -1;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (freq[i] > 0) {
                targetFrequency = freq[i];
                break;
            }
        }

        // Check if all non-zero frequencies are the same
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (freq[i] > 0 && freq[i] != targetFrequency) {
                return false;
            }
        }

        return true;
    }
}