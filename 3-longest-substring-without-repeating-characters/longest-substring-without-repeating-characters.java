public class Solution {

    // Function to find the length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // Hash table to store the last occurrence index of characters (256 for ASCII)
        int[] hashTable = new int[256];  // Initialize all elements to 0 by default

        // Initialize the hash table with -1 (indicating no character has been seen yet)
        for (int i = 0; i < 256; i++) {
            hashTable[i] = -1;
        }

        int maxLength = 0;
        int start = 0; // Left pointer of the window

        // Traverse the string with 'end' pointer
        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the window, move the start pointer
            if (hashTable[currentChar] >= start) {
                start = hashTable[currentChar] + 1;
            }

            // Update the last occurrence of the current character
            hashTable[currentChar] = end;

            // Calculate the current length of the substring and update maxLength
            int currentLength = end - start + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
}
